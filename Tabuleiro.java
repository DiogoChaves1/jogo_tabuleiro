import java.util.ArrayList;

class Tabuleiro {
    private ArrayList<Jogador> jogadores;
    private int rodada;

    public Tabuleiro(){
        rodada = 0;
        jogadores = new ArrayList<Jogador>();
    }

    public boolean AddJogador(Jogador newJogador){
        if(jogadores.contains(newJogador))
            return false;

        jogadores.add(newJogador);
        return true;
    }
}