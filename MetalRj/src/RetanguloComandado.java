import java.awt.Color;
import java.awt.Graphics;


public class RetanguloComandado extends Retangulos{
  
    private int cima;
    private int baixo;
    private int direita;
    private int esquerda;
public RetanguloComandado(int pX, int pY, int cima, int baixo, int direita, int esquerda){
        this.posX = pX;
        this.posY = pY;
        this.cima = cima;
        this.baixo = baixo;
        this.direita = direita;
        this.esquerda = esquerda;
}
 public void atualizarCoordenadas(Teclado t) {

        if (t.teclaApertada(cima)){
            posY--;
        }
        if (t.teclaApertada(baixo)){
            posY++;
        }
        if (t.teclaApertada(direita)){
            posX++;
        }
        if (t.teclaApertada(esquerda)){
            posX--;
        }

    }
 public void desenhar(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(posX, posY, 20, 20);
    }
}