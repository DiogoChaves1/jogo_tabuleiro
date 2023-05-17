import java.util.ArrayList;

public class Menu {

    public void mostrarJogadores(ArrayList<Jogador> jogadores) {
        System.out.println();
        for(Jogador jogador: jogadores) {
            System.out.println(jogador.toString());
        }
    }
    public void mostrarMenuInicial(){
        System.out.println("________________________________________");
        System.out.println("          Jogo de Tabuleiro");
        System.out.println("________________________________________");
        System.out.println("1 - Começar jogo");
        System.out.println("2 - Adicionar Jogador");
        System.out.println("________________________________________");
        System.out.println("Digite 1 ou 2 para selecionar uma opção");
        System.out.println("----------------------------------------");
    }

    public void mostrarTelaDeAdição(Jogador jogador){
        System.out.println("__________________________________________________");
        System.out.println("Jogador "+jogador.getCor()+" adicionado!");
        if(jogador instanceof JogadorAzarado ){
            System.out.println("Que Pena! você tirou uma carta de azar:");
            System.out.println("----------------------------------------");
            System.out.println("Você acidentalmente quebrou o espelho da");
            System.out.println("sua casa, parece que vai ficar sem sorte");
            System.out.println("por um tempo.");
            System.out.println("----------------------------------------");

        }
        if(jogador instanceof JogadorNormal){
            System.out.println("Ah... você tirou uma carta comum, que sem graça!:");
            System.out.println("------------------------------------------------");
            System.out.println("Você decide dar uma volta com seu cachorro");
            System.out.println("parece apenas mais um dia normal");
            System.out.println("----------------------------------------");

        }
        if(jogador instanceof JogadorSortudo){
            System.out.println("Uau! você tirou uma carta de sorte:");
            System.out.println("------------------------------------------------");
            System.out.println("Você acorda pela manhã e decide dar uma volta no");
            System.out.println("parque da cidade, chegando lá você encontra");
            System.out.println("próximo a um banco um trevo de quatro folhas.");
            System.out.println("Parece que é seu dia de sorte.");
            System.out.println("----------------------------------------");

        }
        System.out.println("________________________________________________");
    }
}
