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


            while(opcao != 1){
                menu.mostrarMenuInicial();
                opcao = leitor.nextInt();
                clearBuffer(leitor);

                if(opcao==1){
                    if(partida.getJogadores().size()>1){
                        break;
                    }
                    else{
                        menu.enviarMensagemErro();
                        opcao=0;
                    }
                }
                else if(opcao == 2 ){
                    newJogador = partida.definirJogador();
                    if(partida.addJogador(newJogador)){
                        newJogador.setCor(partida.getJogadores().indexOf(newJogador));
                        menu.mostrarTelaDeAdição(newJogador);
                    } else 
                    System.out.println("Limite de jogadores atingido, você só pode criar 6 jogadores");

                    //aqui irá a tela das informações do jogador criado. (cor e tipo)
                    menu.mostrarDadosDeJogadores(partida.getJogadores());

                }
                
            }

        do{
            partida.setRodada(1);
            System.out.println("RODADA DE NUMERO - " + partida.getRodada());
            for (Jogador jogador : partida.getJogadores()) {
                menu.iniciarJogadas(jogador);
                menu.mostrarJogadores(partida.getJogadores());

                if(jogador.podeJogar == false){
                    partida.checkCasasEspeciais(jogador);
                    continue;
                }
                do{
                System.out.println("Aperte enter para rolar os dados");
                comando = leitor.nextLine();
                dados = jogador.jogarDados();
                jogador.setPosição(dados);
                //mostrar posição 
                partida.checkCasasEspeciais(jogador);
                }while(jogador.isJogaDadosNovamente());

                if(jogador.posição >= 40){  
                    jogador.setPosição();
                    jogador.setPosição(40);
                    checkGanhador = true;
                    break;
                }
                menu.mostrarJogadores(partida.getJogadores());
            }

        }while(checkGanhador != true);
        System.out.println("Fim de jogo");
        leitor.close();
    }   
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
