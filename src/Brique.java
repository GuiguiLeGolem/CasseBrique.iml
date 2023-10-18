import java.awt.*;

public class Brique extends Rectangle{
    public Brique(int positionX, int positionY, Color couleur, int largeur, int hauteur) {
        super(positionX, positionY, couleur, largeur, hauteur);
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(positionX, positionY, largeur, hauteur);
    }
}
