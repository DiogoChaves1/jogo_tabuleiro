import java.util.Random;
public class JogadorAzarado extends Jogador{

    public JogadorAzarado(){
        super();
    }

    public int jogarDados(){
        Random gerador = new Random();
        int dado1, dado2;

        do{ 
            dado1 = gerador.nextInt(6) + 1;
            dado2 = gerador.nextInt(6) + 1;
        } while( dado1 + dado2 > 6 );
        if(dado1==dado2){
            jogaDadosNovamente=true;
        }
        else{
            jogaDadosNovamente=false;
        }

        System.out.println(cor+" tirou "+dado1+" e "+dado2+", ande "+(dado1+dado2)+" casas");

        return dado1 + dado2;
    }
}
