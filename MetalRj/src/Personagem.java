import java.awt.Graphics;
import java.awt.Image;


public abstract class Personagem {
    protected int posX;
    protected int posY;
    protected int velocidade;
    protected int posColuna; //posição do personagem na coluna da matriz
    protected int posLinha; //posição do personagem na linha da matriz
    protected Tela jogo;  //área de desenho
    protected Image imagem; // imagem 
    protected String imagemNome; // nome da imagem 
      
     public Personagem (Tela t, /*String imagemNome,*/ int pX, int pY, int v, int ml, int mc) {
        this.jogo = t;
        this.posX = pX;
        this.posY = pY;
        this.velocidade = v;
        this.posColuna = mc;
        this.posLinha = ml;


}
   
    public void atualizaCoordenadas(){
        
    }

    public abstract void morrer();

    public abstract void desenhar(Graphics g);
    
}

