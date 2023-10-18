import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Sprite{

    protected int longueur;
    protected int largeur;

    public Barre(int positionX, int positionY, Color couleur, int longueur, int largeur) {
        super(positionX, positionY, couleur);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public void deplacementDroite(){
        this.positionX += 10;
    }

    public void deplacementGauche(){
        this.positionX -= 10;
    }

    @Override
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
}
