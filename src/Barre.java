import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Sprite implements KeyListener {

    protected int longueur;
    protected int largeur;

    public Barre(int positionX, int positionY, int vitesseHorizontal, Color couleur, int longueur, int largeur) {
        super(positionX, positionY, vitesseHorizontal, couleur);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public void deplacement(boolean yes){
        if(yes){
            this.positionX += vitesseHorizontal;
        }
        else if (!yes){
            this.positionX -= vitesseHorizontal;
        }
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(positionX, positionY, longueur, largeur);
    }

    public void testCollision(){
        if(this.positionX >= CasseBrique.largeur - longueur){
            this.positionX = CasseBrique.largeur - longueur;
        }
        else if (this.positionX <= 0){
            this.positionX = 0;
        }
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
