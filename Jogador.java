public abstract class Jogador {
    protected String cor;
    protected int posição;
    protected int jogadas;

    public Jogador(String cor, int jogadas){
        this.cor=cor;
        posição = 0;
        this.jogadas=jogadas;
    }

    public abstract int jogarDados();
}
