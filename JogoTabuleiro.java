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
                clearBuffer(leitor);

                if(opcao == 2 ){
                    newJogador = partida.definirJogador();
                    if(partida.addJogador(newJogador)){
                        newJogador.setCor(partida.getJogadores().indexOf(newJogador));
                        System.out.println("jogador " + newJogador.getCor() + " adicionado com sucesso :)");
                    } else 
                    System.out.println("Limite de jogadores atingido, você só pode criar 6 jogadores");

                    //aqui irá a tela das informações do jogador criado. (cor e tipo)


                }
                
            }

        do{
            partida.setRodada(1);
            System.out.println("RODADA DE NUMERO - " + partida.getRodada());
            for (Jogador jogador : partida.getJogadores()) {
                //aqui irá a tela de iniciar as jogadas "vez do jogador fulano..."
                // tela mostrando as casas no início da rodada

                if(jogador.podeJogar == false){
                    partida.checkCasasEspeciais(jogador);
                    continue;
                }

                System.out.println("Aperte enter para rolar os dados");
                comando = leitor.nextLine();
                
                dados = jogador.jogarDados();
                jogador.setPosição(dados);
                //mostrar posição 
                partida.checkCasasEspeciais(jogador);
                
                if(jogador.posição >= 40){  
                    jogador.setPosição();
                    jogador.setPosição(40);
                    checkGanhador = true;
                    break;
                }
                menu.mostrarJogadores(partida.getJogadores());
            }

        }while(checkGanhador != true);
        leitor.close();
    }   
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
