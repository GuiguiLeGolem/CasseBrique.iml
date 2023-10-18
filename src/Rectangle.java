import java.awt.*;

public class Rectangle extends Sprite{
    protected int largeur;
    protected int hauteur;

    public Rectangle(int positionX, int positionY, Color couleur, int largeur, int hauteur) {
        super(positionX, positionY, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(Graphics2D graphics2D) {

    }
}
