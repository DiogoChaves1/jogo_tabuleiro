import java.util.Random;
public class JogadorNormal extends Jogador {

    public JogadorNormal() {
        super();
    }

    public int jogarDados() {
        Random gerador = new Random();
        int dado1;
        int dado2;

        dado1 = gerador.nextInt(6)+1;
        dado2 = gerador.nextInt(6)+1;

        if(dado1==dado2){
            jogaDadosNovamente=true;
        }
        else{
            jogaDadosNovamente=false;
         } 
        
        return dado1 + dado2;
    }

}
