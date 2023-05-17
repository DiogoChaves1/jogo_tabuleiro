import java.util.*;

public class Tabuleiro {
    private ArrayList<Jogador> jogadores;
    private int rodada;
    Menu menu  = new Menu();

    public Tabuleiro(){
        rodada = 0;
        jogadores = new ArrayList<Jogador>();
    }
    public Jogador definirJogador(){
        Jogador newJogador;
        Random gerador = new Random();
        int sorteioTipo;
        if(jogadores.size()==1){
            return gerarJogadorDiferente();
        }

        sorteioTipo= gerador.nextInt(2);
        switch(sorteioTipo){
            case 0:
                newJogador = new JogadorNormal();
                return newJogador;
            
            case 1:
                newJogador = new JogadorAzarado();
                return newJogador;

            default:
                newJogador = new JogadorSortudo();
                return newJogador;
        }
    }
    public Jogador gerarJogadorDiferente(){
        Jogador newJogador;
        Random gerador = new Random();
        int sorteioTipo;

            sorteioTipo= gerador.nextInt(1);
            if(jogadores.get(0) instanceof JogadorNormal){
                if(sorteioTipo==0){
                    newJogador=new JogadorAzarado();
                    return newJogador;
                }
                else{
                    newJogador=new JogadorSortudo();
                    return newJogador;
                }

            }
            else if(jogadores.get(0) instanceof JogadorAzarado){
                if(sorteioTipo==0){
                    newJogador=new JogadorNormal();
                    return newJogador;
                }
                else{
                    newJogador=new JogadorSortudo();
                    return newJogador;
                }
            }
            else{
                if(sorteioTipo==0){
                    newJogador=new JogadorAzarado();
                    return newJogador;
                }
                else{
                    newJogador=new JogadorNormal();
                    return newJogador;
                }

            }

    }

    public boolean addJogador(Jogador newJogador){
        if(jogadores.size() == 6 )
            return false;

        jogadores.add(newJogador);
        return true;
    }

    public void mostrarPosição(){
        for(Jogador jogador: jogadores){
            System.out.println(jogador.toString());
        }
    }
    public int ativarCasaDeMudança(Jogador jogador){
        Random gerador = new Random();
        int tipo, indexJogador=jogadores.indexOf(jogador);
        tipo = gerador.nextInt(2);

        menu.mostrarMensagemInicialCasasEspeciais(2);
        switch(tipo){    
            case 0:
                JogadorAzarado newJogadorAzarado = new JogadorAzarado();
                newJogadorAzarado.setCor(jogador.getCor());

                newJogadorAzarado.setPosição(jogador.getPosição());
                newJogadorAzarado.setTurno(jogador.getTurno());
                jogadores.set(indexJogador, newJogadorAzarado);
            
                return 0;
            case 1:
                JogadorSortudo newJogadorSortudo = new JogadorSortudo();
                newJogadorSortudo.setCor(jogador.getCor());

                newJogadorSortudo.setPosição(jogador.getPosição());
                newJogadorSortudo.setTurno(jogador.getTurno());
                jogadores.set(indexJogador, newJogadorSortudo);
            
                return 1;
            default:
                JogadorNormal newJogadorNormal = new JogadorNormal();
                newJogadorNormal.setCor(jogador.getCor());

                newJogadorNormal.setPosição(jogador.getPosição());
                newJogadorNormal.setTurno(jogador.getTurno());
                jogadores.set(indexJogador, newJogadorNormal);
                
                return 2;
        } 
    }

    public void ativarCasasDaSorte(Jogador jogador) {
        if( jogador instanceof JogadorNormal || jogador instanceof JogadorSortudo) {
            menu.mostrarMensagemInicialCasasEspeciais(3);
            jogador.setPosição(3);
        }else {
            System.out.println("Voce eh um azarado, nao pode andar na casa da sorte");
        }

    }

    public void ativarCasaDaDiscordia() {
        String cor;
        int posJogador = 0;
        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();

        menu.mostrarMensagemInicialCasasEspeciais(4);
 
        menu.mostrarJogadores(jogadores);

        cor = entrada.nextLine();

        for(Jogador jogador: jogadores) {
            if(cor.equals(jogador.getCor())) {
                jogador.setPosição();
                posJogador = jogador.getPosição();
            }
        }
        menu.mostrarJogadores(jogadores);

        System.out.println("Posicao atual (" + cor + ") : " + posJogador);

    }

    public void ativarCasaDoAzar(Jogador jogador){
        
        if(jogador.podeJogar == false){  
            jogador.podeJogar = true;
            
            menu.mostrarMensagemFinalCasasEspeciais(1, jogador);
            menu.mostrarTransição(2000);
        }
        else{  
            if(jogador.jogaDadosNovamente == true){
                jogador.jogaDadosNovamente = false;
                System.out.println("Voce ganhou um bilhete para jogar duas vezes, mas infelizmente uma ventania o levou...");
            }
            menu.mostrarMensagemInicialCasasEspeciais(1);
            jogador.podeJogar = false;
        }
    }

    public int pegarUlitmoJogador(){
        int ultimaPosicao = 40;
        int indexUltimo = 0;
        
        for (Jogador jogador : jogadores) {
            if(jogador.posição < ultimaPosicao){
                ultimaPosicao = jogador.posição;
                indexUltimo = jogadores.indexOf(jogador);
            }
        }

        return indexUltimo;
    }


    public void ativarCasaMagica(Jogador jogador){
        int indexUltimoJogador = pegarUlitmoJogador();
        int casaUltimoJogador;

        if(indexUltimoJogador == jogadores.indexOf(jogador)) {  
            System.out.println("O jogador " + jogador.cor  + "ja esta na ultima posicao... :´( ");

            return;
        }

        menu.mostrarMensagemInicialCasasEspeciais(5);

        casaUltimoJogador = jogadores.get(indexUltimoJogador).getPosição();
        jogadores.get(indexUltimoJogador).posição = jogador.getPosição();
        jogador.posição = casaUltimoJogador;

        System.out.printf("Posicao atual: %d\n", jogador.getPosição());

    }

    public void checkCasasEspeciais(Jogador jogador){
        switch (jogador.getPosição()) {
            case 10,25,38:
                ativarCasaDoAzar(jogador);
                menu.mostrarTransição(4000);
                break;

            case 13:
                ativarCasaDeMudança(jogador);
                menu.mostrarTransição(4000);
                menu.mostrarMensagemFinalCasasEspeciais(2, jogador);
                menu.mostrarTransição(3500);
                break;

            case 5,15,30:
                ativarCasasDaSorte(jogador);
                menu.mostrarTransição(4000);
                menu.mostrarMensagemFinalCasasEspeciais(3, jogador);
                menu.mostrarTransição(3500);
                break;

            case 17,27: 
                ativarCasaDaDiscordia();
                menu.mostrarTransição(4000);
                menu.mostrarMensagemFinalCasasEspeciais(4, jogador);
                menu.mostrarTransição(3500);
                break;
            
            case 20,35:
                ativarCasaMagica(jogador);
                menu.mostrarTransição(4000);
                menu.mostrarMensagemFinalCasasEspeciais(5, jogador);
                menu.mostrarTransição(3500);
                break;
                
            default:
                break;
        }
    }

    
    public int getRodada(){
        return rodada;
    }

    public void setRodada(int rodada){
        this.rodada += rodada;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

}