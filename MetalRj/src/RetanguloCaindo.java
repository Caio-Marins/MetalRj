import java.awt.Color;
import java.awt.Graphics;

public class RetanguloCaindo extends Retangulos {

  
    private boolean subindo;
    private Tela pai;

    public RetanguloCaindo(int pX, int pY, Tela t) {
        posX = pX;
        posY = pY;
        pai = t;
        subindo = false;

    }

    public void desenhar(Graphics g) {
       // g.setColor(Color.PINK);
        //g.fillRect(posX, posY, 20, 20);
        
    }

    public void atualizarY() {
        //posY++;

        if (subindo == false) {
                if ((posY + 20 + 1) < pai.getHeight()) {
                    posY = posY + 20;
                   

                } else {
                subindo = !subindo;
                }
            }
            if (subindo == true) {
                if ((posY - 1) > 0) {
                    posY--;
                } else {
                    subindo = !subindo;
                }
            }
      }
    }

