import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Jogador> jogadores;
    private int rodada;

    public Tabuleiro(){
        rodada = 0;
        jogadores = new ArrayList<Jogador>();
    }

    public boolean addJogador(Jogador newJogador){
        if(jogadores.contains(newJogador) || jogadores.size() > 5 )
            return false;

        jogadores.add(newJogador);
        return true;
    }

    public void mostrarPosição(){
        for(Jogador jogador: jogadores){
            System.out.println(jogador.toString());
        }
    }

    public void checkCasasDaSorte(Jogador jogador) {
        if( jogador instanceof JogadorNormal || jogador instanceof JogadorSortudo) {
            System.out.println("Voce esta em uma casa da sorte. +3 casas");
            jogador.posição += 3;
            System.out.printf("Posicao atual: %d\n", jogador.posição);
        }

        System.out.printf("Posicao atual: %d\n", jogador.posição);
    }

    public void checkCasaDeTroca(String cor) {
        for(Jogador jogador: jogadores) {
            if(cor == jogador.cor) {
                jogador.posição = 0;
            }
        }
    }

    public boolean checkCasaDoAzar(Jogador jogador){
        if(jogador.posição == 10 || jogador.posição == 25 || jogador.posição == 38){
            return true;
        }

        return false;
    }

    public void checkCasaMagica(Jogador jogador){
        int menorPosicao = jogador.posição;
        int indexMenorPosicao = 0;

        for (Jogador jogadorTroca : jogadores) {
            if(jogadorTroca.posição < menorPosicao){
                menorPosicao = jogadorTroca.posição;
                indexMenorPosicao = jogadores.indexOf(jogadorTroca);
            }
        }
        if(menorPosicao == jogador.posição) {  
            System.out.println("O jogador " + jogador.cor  + "ja esta na ultima posicao... :´( )");
            
            return;
        }
        jogadores.get(indexMenorPosicao).posição = jogador.posição;
        jogador.posição = menorPosicao;

    }
    
    public int getRodada(){
        return rodada;
    }
    public void setRodada(int rodada){
        this.rodada=rodada;
    }

}