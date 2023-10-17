import java.awt.*;

public class Sprite {
    protected int positionX;
    protected int positionY;
    protected int vitesseHorizontal;
    protected Color couleur;

    public Sprite(int positionX, int positionY, int vitesseHorizontal, Color couleur) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.vitesseHorizontal = vitesseHorizontal;
        this.couleur = couleur;
    }

    public void dessiner(Graphics2D graphics2D){

    }

    public void testCollision(){

    }

    public void deplacement(){

    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
