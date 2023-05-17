import java.util.Random;
public class JogadorSortudo extends Jogador{
    
    public JogadorSortudo(){
        super();
    }
    public int jogarDados(){
        Random gerador = new Random();
        int dado1, dado2;

        do{
            dado1 = gerador.nextInt(6)+1;
            dado2 = gerador.nextInt(6)+1;
        }
         while( dado1 + dado2 < 7 );
        
         if(dado1==dado2){
            jogaDadosNovamente=true;
         }
         else{
            jogaDadosNovamente=false;
         }
         System.out.println(cor+" tirou "+dado1+" e "+dado2+", ande "+(dado1+dado2)+" casas");
 
        return dado1+dado2;
    }

}
