import java.util.*;


public class JogoTabuleiro {

    public static void main(String args[]){
        Tabuleiro partida = new Tabuleiro();
        Menu menu = new Menu();
        Jogador newJogador;
        Scanner leitor = new Scanner(System.in);
        
        int dados, opcao = 0; 
        boolean checkGanhador = false;
        String comando, vencedor="";


            while(opcao != 1){
                menu.mostrarMenuInicial();
                opcao = leitor.nextInt();
                clearBuffer(leitor);
                menu.ClearConsole();
                menu.mostrarTransição(1100);

                if(opcao==1){
                    if(partida.getJogadores().size()>1){
                        break;
                    }
                    else{
                        menu.enviarMensagemErro();
                        opcao=0;
                    }
                }
                else{
                    newJogador = partida.definirJogador();

                    if(partida.addJogador(newJogador)){
                        newJogador.setCor(partida.getJogadores().indexOf(newJogador));

                        menu.mostrarTelaDeAdição(newJogador);
                        menu.mostrarTransição(4500);
                        menu.ClearConsole();
                    } else {  
                    System.out.println("Limite de jogadores atingido, você só pode criar 6 jogadores");
                    }

                    menu.mostrarDadosDeJogadores(partida.getJogadores());
                    System.out.println("");

                }
                
            }

        do{
            partida.setRodada(1);
            for (Jogador jogador : partida.getJogadores()) {
                menu.mostrarTransição(3000);
                menu.ClearConsole();
                System.out.println("---------------   RODADA " + partida.getRodada()+    "   ---------------");
                
                if(jogador.podeJogar == false){
                    partida.checkCasasEspeciais(jogador);
                    continue;
                               }
                do{
                    if(jogador.isJogaDadosNovamente()){ 
                        if(jogador.posição >= 40)
                            break; 
                        System.out.println("---------------- "+jogador.getCor() + " joga novamente ----------------");
                        menu.mostrarTransição(1200);
                        jogador.setTurno(1);

                    }
                    menu.iniciarJogadas(jogador);
                    menu.mostrarJogadores(partida.getJogadores());

                    System.out.println("Aperte enter para rolar os dados");
                    comando = leitor.nextLine();
                    dados = jogador.jogarDados();
                    menu.mostrarMensagemFinalCasasEspeciais(1, jogador);
                    jogador.setTurno(1);
                    menu.mostrarTransição(4000);
                    menu.ClearConsole();
                    jogador.setPosição(dados);
                 
                    partida.checkCasasEspeciais(jogador);
                    menu.ClearConsole();
                }while(jogador.isJogaDadosNovamente());

                if(jogador.posição >= 40){  
                    jogador.setPosição();
                    jogador.setPosição(40);
                    checkGanhador = true;
                    vencedor=jogador.getCor();
                    break;
                }
                menu.mostrarJogadores(partida.getJogadores());
            }

        }while(checkGanhador != true);
        menu.mostrarJogadas(partida.getJogadores());
        System.out.println("----------------------------------------");
        System.out.println("O jogador "+vencedor+" é o campeão");
        System.out.println("----------------------------------------");
        leitor.close();
    }   
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
