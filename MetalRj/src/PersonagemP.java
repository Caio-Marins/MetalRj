import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PersonagemP extends Personagem {

   
    protected String nome;
    protected int cima;
    protected int baixo;
    protected int direita;
    protected int esquerda;
    protected Image PersonagemP;
    protected int vidas;
    private PersonagemP pp;
    protected boolean atingido;
    protected ArrayList<Tiro> tiro;
    protected int atirar;
    protected int pontuacao;

    public PersonagemP(Tela pai, int pX, int pY, int combustivel, int v, int vidas, String n, int cima, int baixo, int direita, int esquerda, int atirar, int ml, int mc) {
        super(pai, pX, pY, v, ml, mc);
        this.nome = n;
        this.vidas = vidas;
        this.cima = cima;
        this.baixo = baixo;
        this.direita = direita;
        this.esquerda = esquerda;
        this.atirar = atirar;
        atingido = false;
        tiro = new ArrayList<Tiro>();
        pontuacao = 0;
    }

    public void atualizaCoordenadas(Teclado t) {
        for (Tiro tiro : this.tiro) {
            tiro.atualizaCoordenadas();
        }
        for (int i = 0; i < tiro.size(); i++) { //tiro.size = quantidade de tiros dentro do arrayList
            Tiro a = tiro.get(i); //pegar uma cópia dentro do arrayList e chama de a
            if (a.posLinha < 0) {
                tiro.remove(i);
            } else if (jogo.validacaoCombustivel(a.posLinha, a.posColuna)) { // a = tiro
                jogo.cenario[a.posLinha][a.posColuna] = 1; //tira o posto e coloca água
                tiro.remove(i);
            } else if (jogo.validacaoPonte(a.posLinha, a.posColuna)) {
                jogo.cenario[a.posLinha][11] = 1; //ponte ocupa colunas 12, 13, 14, 15
                jogo.cenario[a.posLinha][12] = 1;
                jogo.cenario[a.posLinha][13] = 1;
                jogo.cenario[a.posLinha][14] = 1;
                tiro.remove(i);
                pontuacao = pontuacao + 500;
            }
            for (int j = 0; j < jogo.inimigo.size(); j++) { //ver se tiro atingiu inimigo
                Inimigo b = jogo.inimigo.get(j);
                if ((b.posLinha == a.posLinha) && (b.posColuna == a.posColuna)) {
                    jogo.inimigo.remove(j);
                    tiro.remove(i);
                    if (b.tipoDeImagem == 0){
                        pontuacao = pontuacao + 200;
                    }else{
                        pontuacao = pontuacao + 100;
                    }
                }
            }
        }
        if (t.teclaApertada(atirar)) {
            this.atirar();
        }

        if (jogo.validacao(posLinha - 1, posColuna) == false) {
            jogo.perdeVida();

        }

        if (t.teclaApertada(cima)) {
            if (posLinha - 1 > 0) { //confere se vai sair do cenario (se vai para linha-0)
                if (jogo.validacao(posLinha - 1, posColuna)) {
                    this.posY = posY - 40;
                    posLinha--;
                } else {
                    jogo.perdeVida();

                }
            }
        }
        if (t.teclaApertada(baixo)) {
            if (posLinha + 1 < 10) {
                if (jogo.validacao(posLinha + 1, posColuna)) { //posLinha + 1 é para onde a nave quer ir
                    this.posY = posY + 40;
                    posLinha++;
                } else {
                    jogo.perdeVida();
                }
            }
        }
        if (t.teclaApertada(direita)) {
            if (jogo.validacao(posLinha, posColuna + 1)) {
                this.posX = posX + 40;
                posColuna++;
            } else {
                jogo.perdeVida();
            }
        }
        if (t.teclaApertada(esquerda)) {
            if (jogo.validacao(posLinha, posColuna - 1)) {
                this.posX = posX - 40;
                posColuna--;
            } else {
                jogo.perdeVida();
            }
        }
        for (int j = 0; j < jogo.inimigo.size(); j++) { //ver se tiro atingiu inimigo
            Inimigo b = jogo.inimigo.get(j);
            if ((b.posLinha == posLinha) && (b.posColuna == posColuna)) {
                jogo.perdeVida();

            }
        }
        if (jogo.validacaoPonte(posLinha, posColuna)) { //se a nave for em direção a ponte
            jogo.perdeVida();
            jogo.perdeVida();
            jogo.perdeVida();
        }
        if (jogo.validacaoPonte(posLinha - 1, posColuna)) { //se a ponte vim na direção da nave
            jogo.perdeVida();
            jogo.perdeVida();
            jogo.perdeVida();
        }
        if (jogo.validacaoVida(posLinha, posColuna)){
            this.vidas++;
            jogo.principal.jLvidas.setText("" + this.vidas);
            jogo.cenario[posLinha][posColuna] = 1; //tirando vida da dela
        }
    }

    public void morrer() {
    }

    public void desenhar(Graphics g) {
        //if(tempoPisca % 3 == 0){
        this.PersonagemP = (new ImageIcon(this.getClass().getResource("/imagens/Principal.jpg"))).getImage();
        g.drawImage(this.PersonagemP, this.posX, this.posY, this.jogo);
        for (Tiro tiro : this.tiro) {
            tiro.desenhar(g);
        }

    }

    public void repaint(Graphics g) {
        g.drawImage(this.PersonagemP, this.posX, this.posY, this.jogo);
    }

    public void atirar() {
        Tiro novoTiro = new Tiro(jogo, posX, posY - 40, 40, this.posLinha - 1, this.posColuna);
        tiro.add(novoTiro);
    }

    public void pontuacao() {
    }
}
