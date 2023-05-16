import java.util.*;

public class JogoTabuleiro {

    public static void main(String args[]){
        Tabuleiro partida = new Tabuleiro();
        Menu menu = new Menu();
        Jogador newJogador;
        Scanner leitor = new Scanner(System.in);
        
        int dados, opcao = 0; 
        boolean checkGanhador = false;
        String comando;


            while(opcao != 1 ){
                //aqui irá a tela de add jogador e iniciar jogo.

                opcao = leitor.nextInt();

                if(opcao == 2 ){
                    newJogador = partida.definirJogador();
                    if(partida.addJogador(newJogador)){
                        newJogador.setCor(partida.getJogadores().indexOf(newJogador));
                    } else 
                    System.out.println("Limite de jogadores atingido, você só pode criar 6 jogadores");

                    //aqui irá a tela das informações do jogador criado. (cor e tipo)


                }
                
            }

        do{
            for (Jogador jogador : partida.getJogadores()) {
                //aqui irá a tela de iniciar as jogadas "vez do jogador fulano..."
                if(jogador.podeJogar == false){
                    partida.checkCasasEspeciais(jogador);
                    continue;
                }
                System.out.println("Aperte enter para rolar os dados");
                leitor.nextLine();
                dados = jogador.jogarDados();
                jogador.setPosição(dados);
                partida.checkCasasEspeciais(jogador);
                menu.mostrarJogadores(partida.getJogadores());
                if(jogador.posição == 40){  
                    checkGanhador = true;
                    break;
                }
            }

        }while(checkGanhador != true);
        leitor.close();
}   
}
