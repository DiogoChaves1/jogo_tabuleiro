import java.util.*;

public class JogoTabuleiro {

    public static void main(String args[]){
        Tabuleiro partida = new Tabuleiro();
        int dados; 
        Menu menu = new Menu();

        Jogador newJogador;
        boolean checkGanhador = false;

        Scanner leitor = new Scanner(System.in);
        
        String comando;


        System.out.println("Seja bem vindo ao Rummikub");
        System.out.println("aperte enter para continuar");
        
        leitor.nextLine();

        do{
            for (Jogador jogador : partida.getJogadores()) {
                //aqui irá a tela de iniciar as jogadas "vez do jogador fulano..."
                if(jogador.podeJogar == false){
                    partida.checkCasasEspeciais(jogador, jogador.posição);
                    continue;
                }
                dados = jogador.jogarDados();
                jogador.setPosição(dados);
                partida.checkCasasEspeciais(jogador, jogador.posição);
                menu.mostrarJogadores(partida.getJogadores());
                if(jogador.posição == 40){  
                    checkGanhador = true;
                    break;
                }
            }

        }while(checkGanhador != true);
        
}   
}
