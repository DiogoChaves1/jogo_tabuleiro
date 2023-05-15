import java.util.ArrayList;

public class Menu {

    public void mostrarJogadores(ArrayList<Jogador> jogadores) {
        for(Jogador jogador: jogadores) {
            System.out.println(jogador.toString());
        }
    }
}
