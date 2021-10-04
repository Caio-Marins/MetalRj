import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Tiro extends Personagem {
    
    private Image tiro;

    public Tiro(Tela t, int pX, int pY, int v, int ml, int mc) {
        super(t, pX, pY, v, ml, mc);
    }
    
    @Override
    public void atualizaCoordenadas() {
      this.posY = posY - 40;
      posLinha--;
    
    }

    /**
     *
     */
    @Override
    public void morrer() {

    }


    public void desenhar(Graphics g) {
        this.tiro = (new ImageIcon(this.getClass().getResource("/imagens/tiro.png"))).getImage();
        g.drawImage(this.tiro, this.posX, this.posY, this.jogo);
        
    }

}
