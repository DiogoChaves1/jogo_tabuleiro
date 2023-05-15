import java.util.Random;
public class JogadorNormal extends Jogador {

    public JogadorNormal(String cor) {
        super(cor);
    }

    public int jogarDados() {
        Random gerador = new Random();
        int dado1;
        int dado2;

        dado1 = gerador.nextInt(6)+1;
        dado2 = gerador.nextInt(6)+1;

        return dado1 + dado2;
    }

    public void setPosicao(int posição){
        this.posição = posição;
    }
}
