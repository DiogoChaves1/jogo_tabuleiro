public abstract class Jogador {
    protected String cor;
    protected int posição;
    protected int turno;
    protected boolean podeJogar;

    public Jogador(String cor){
        this.cor=cor;
        posição = 0;
        turno = 0;
        podeJogar = true;
    }

    public abstract int jogarDados();

    public abstract void setPosicao(int posição);
}
