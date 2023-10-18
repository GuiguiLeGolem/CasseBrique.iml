import java.awt.*;
import java.util.ArrayList;

public class Balle extends Rond implements Deplacable{
    private int vitesseHorizontal;
    private int vitesseVertical;

    public Balle(int positionX, int positionY, Color couleur, int diametre, int vitHori, int vitVert) {
        super(positionX, positionY, couleur, diametre);
        this.vitesseHorizontal = vitHori;
        this.vitesseVertical = vitVert;
    }

    public void deplacement() {
        this.positionX += this.vitesseHorizontal;
        this.positionY += this.vitesseVertical;
    }

    public void testCollision() {
        if(this.positionX >= CasseBrique.largeur - diametre || this.positionX <= 0) {
            this.vitesseHorizontal = - vitesseHorizontal;
        }
        if(this.positionY >= CasseBrique.hauteur - diametre || this.positionY <= 0) {
            this.vitesseVertical = -vitesseVertical;
        }
    }

    public void rebond(Barre barre){
        int uneDemiBarreHorizontal = barre.longueur/2;
        int uneDemiBarreVertical = barre.largeur/2;
        int extremiteGaucheX = barre.positionX - uneDemiBarreHorizontal;
        int extremiteDroiteX = barre.positionX + uneDemiBarreHorizontal;
        int extremiteSupperieur = barre.positionY - uneDemiBarreVertical;

        //vérifier que la balle touche la barre Verticalement / Axe Y
        if((this.positionX + this.diametre) >= extremiteGaucheX && (this.positionX - this.diametre) <= extremiteDroiteX){
            //vérifier que la balle touche la barre Horizontalement / Axe X
            if((this.positionY + (this.diametre/2)) >= extremiteSupperieur){
                this.vitesseVertical = - vitesseVertical;
            }
        }
    }

    public void detruitBrique(ArrayList<Brique> listeBrique) {
        for(Brique brique: listeBrique){
            if(this.positionX <= (brique.positionX + (brique.largeur/2)) && this.positionX >= (brique.positionX - (brique.largeur/2))){
                if(this.positionY <= (brique.positionY + (brique.hauteur/2)) && this.positionY >= (brique.positionY - (brique.hauteur/2))){
                    listeBrique.remove(brique);
                    this.vitesseHorizontal = - this.vitesseHorizontal;
                    this.vitesseVertical = - this.vitesseVertical;
                    break;
                }
            }
        }
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }
}
