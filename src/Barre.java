import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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

    public void colisionBonus(ArrayList<Bonus> lesBonus){
        int uneDemiBarreHorizontal = longueur/2;
        int uneDemiBarreVertical = largeur/2;
        int extremiteGaucheX = positionX - uneDemiBarreHorizontal;
        int extremiteDroiteX = positionX + uneDemiBarreHorizontal;
        int extremiteSupperieurY = positionY - uneDemiBarreVertical;
        int extremiteInferieurY = positionY + uneDemiBarreVertical;

        for(Bonus bonus: lesBonus){

            int coteHautBonus = bonus.positionY - (bonus.hauteur/2);
            int coteBasBonus = bonus.positionY + (bonus.hauteur/2);
            int coteGaucheBonus = bonus.positionX - (bonus.largeur/2);
            int coteDroitBonus = bonus.positionX + (bonus.largeur/2);

            if(bonus.positionY >= extremiteSupperieurY &&  bonus.positionY <= extremiteInferieurY){
                if((bonus.positionX >= extremiteGaucheX && bonus.positionX <= extremiteDroiteX)
                        || ((coteGaucheBonus <= extremiteGaucheX && coteDroitBonus >= extremiteGaucheX)
                        || (coteDroitBonus >= extremiteDroiteX && coteGaucheBonus <= extremiteDroiteX))){
                    bonus.testCollision();
                }
            }
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
