import java.util.ArrayList;

class Tabuleiro {
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

    public int getRodada(){
        return rodada;
    }
    public void setRodada(int rodada){
        this.rodada=rodada;
    }

}