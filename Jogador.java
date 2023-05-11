public abstract class Jogador {
    protected String cor;
    protected int posição;
    protected int jogadas;

    public Jogador(String cor, int posição, int jogadas){
        this.cor=cor;
        this.posição=posição;
        this.jogadas=jogadas;
    }

    public abstract int jogarDados();

}
