import java.awt.*;
import java.util.function.DoubleToIntFunction;

public class Balle {

    private int positionX = 0;
    private int vitesseHorizontal = 4;
    private int positionY = 0;
    private int vitesseVertical = 3;
    private int diametre = 30;
    private Color couleur = Color.blue;

    public void deplacement() {
        this.positionX += this.vitesseHorizontal;
        this.positionY += this.vitesseVertical;
        //System.out.println("debug: positionY == " + this.positionY);
    }

    public void testCollision() {
        if(this.positionX >= CasseBrique.largeur - diametre || this.positionX <= 0) {
            this.vitesseHorizontal = - vitesseHorizontal;
        }
        if(this.positionY >= CasseBrique.hauteur - diametre || this.positionY <= 0) {
            this.vitesseVertical = -vitesseVertical;
        }
    }

    public void dessiner (Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(positionX,positionY,diametre,diametre);
    }

    public void rebond(Barre barre){



        if(this.positionY >= (barre.positionY + (barre.largeur/2))){

            //vérifier que la balle touche la barre horizontalement
            if(this.positionX <= (barre.positionX + barre.longueur/2) || this.positionX >= (barre.positionX + barre.longueur/2)){
                this.vitesseVertical = - vitesseVertical;
            }

        }
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }
}
