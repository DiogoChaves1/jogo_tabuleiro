import java.util.Random;
public class JogadorAzarado extends Jogador{

    public JogadorAzarado(String cor){
        super(cor);
    }

    public int jogarDados(){
        Random gerador = new Random();
        int dado1, dado2;

        do{ 
            dado1 = gerador.nextInt(6) + 1;
            dado2 = gerador.nextInt(6) + 1;
        } while( dado1 + dado2 > 6 );
        
        return dado1 + dado2;
    }
    
}
