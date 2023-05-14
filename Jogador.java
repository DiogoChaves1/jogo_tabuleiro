public abstract class Jogador {
    protected String cor;
    protected int posição;
    protected int turno;

    public Jogador(String cor){
        this.cor=cor;
        posição = 0;
        turno = 0;
    }

    public abstract int jogarDados();
}
