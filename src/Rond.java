import java.awt.*;

public class Rond extends Sprite{
    protected int diametre;

    public Rond(int positionX, int positionY, Color couleur, int diametre) {
        super(positionX, positionY, couleur);
        this.diametre = diametre;
    }

    @Override
    public void dessiner(Graphics2D graphics2D) {
        graphics2D.setColor(couleur);
        graphics2D.fillOval(positionX, positionY, diametre, diametre);
    }
}
