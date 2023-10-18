import java.awt.*;

public class Bonus extends Rectangle implements Deplacable{

    public Bonus(int positionX, int positionY, Color couleur, int largeur, int hauteur) {
        super(positionX, positionY, couleur, largeur, hauteur);
    }

    @Override
    public void deplacement() {
        positionY -= 5;
    }

    @Override
    public void testCollision() {

    }
}
