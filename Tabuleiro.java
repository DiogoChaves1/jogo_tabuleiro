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
        for(Jogador j: jogadores){
        System.out.println(j.toString());
        }
    }

    public void checkCasasDaSorte(Jogador j) {
        if( j instanceof JogadorNormal || j instanceof JogadorSortudo) {
            System.out.println("Voce esta em uma casa da sorte. +3 casas");
            j.posição += 3;
            System.out.printf("Posicao atual: %d\n", j.posição);
        }

        System.out.printf("Posicao atual: %d\n", j.posição);
    }

    public void casaDeVoltarAoInicio(String cor) {
        for(Jogador j: jogadores) {
            if(cor == j.cor) {
                j.posição = 0;
            }
        }
    }
    
    public int getRodada(){
        return rodada;
    }
    public void setRodada(int rodada){
        this.rodada=rodada;
    }

}