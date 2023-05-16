import java.util.Random;
public class JogadorSortudo extends Jogador{
    
    public JogadorSortudo(){
        super();
    }
    public int jogarDados(){
        Random gerador = new Random();
        int dado1, dado2;

        do{
            dado1=gerador.nextInt(6)+1;
            dado2=gerador.nextInt(6)+1;
        } while( dado1 + dado2 < 7 );

        return dado1+dado2;
    }

}
