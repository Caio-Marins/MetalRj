import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Inimigo extends Personagem {

    protected Image imagemInimigo;
    protected int tipoDeImagem;
    private boolean esquerda;
    private int tempoInimigo;
    
    public Inimigo(Tela pai, int pX, int pY, int v, int ml, int mc, int tipo) {
        super(pai, pX, pY, v, ml, mc);
        esquerda = false;
        this.tipoDeImagem = tipo;
        this.tempoInimigo = 0;
    }

    @Override
    public void atualizaCoordenadas() {
        if (tempoInimigo == 0) {
            if (esquerda == false) {
                if (jogo.validacao(posLinha, posColuna + 1)) {
                    this.posX = posX + 40;
                    posColuna++;
                } else {
                    this.posX = posX - 40;
                    posColuna--;
                    esquerda = !esquerda;
                }

            }
            if (esquerda == true) {
                if (jogo.validacao(posLinha, posColuna - 1)) {
                    this.posX = posX - 40;
                    posColuna--;
                } else {
                    this.posX = posX + 40;
                    posColuna++;
                    esquerda = !esquerda;
                }
            }
        }
        tempoInimigo ++;
        if (tempoInimigo == 2){ //tempo do inimigo = 2*tempo de atualização
            tempoInimigo = 0;
        }
    }

    @Override
    public void morrer() {
    }

    @Override
    public void desenhar(Graphics g) {
        if (this.tipoDeImagem == 0) {
            this.imagemInimigo = (new ImageIcon(this.getClass().getResource("/imagens/coxa.jpg"))).getImage();
        } else if(this.tipoDeImagem == 1) {
            this.imagemInimigo = (new ImageIcon(this.getClass().getResource("/imagens/tank.jpg"))).getImage();
        }
        else {
             this.imagemInimigo = (new ImageIcon(this.getClass().getResource("/imagens/jacksahw.jpg"))).getImage();
        }
        
        g.drawImage(this.imagemInimigo, this.posX, this.posY, this.jogo);


    }
}

