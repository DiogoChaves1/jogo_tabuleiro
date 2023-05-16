public abstract class Jogador {
    protected String cor;
    protected int posição;
    protected int turno;
    protected boolean podeJogar;

    public Jogador(){
        cor= "";
        posição = 0;
        turno = 0;
        podeJogar = true;
    }

    public String toString() {
        return cor+", Posicao: " + posição;
    }

    public abstract int jogarDados();

    public String getCor() {
        return cor;
    }

    public void setCor(int index) {
        switch(index){
            case 0:
                cor="Branco";
                break;
            case 1:
                cor="Vermelho";
                break;
            case 2:
                cor="Azul";
                break;
            case 3:
                cor="Preto";
                break;
            case 4:
                cor="Amarelo";
                break;
            default:
                cor="Verde";
                break;
        }
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPosição() {
        return posição;
    }

    public void setPosição(int posição) {
        this.posição += posição;
    
    }
    public void setPosição() {
        posição = 0;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isPodeJogar() {
        return podeJogar;
    }

    public void setPodeJogar(boolean podeJogar) {
        this.podeJogar = podeJogar;
    }

}
