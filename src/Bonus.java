import java.awt.*;
import java.util.Random;
import java.util.random.RandomGenerator;

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
        int result = Random.from(RandomGenerator.getDefault()).nextInt(1,2);

        if(result == 1){
            new Balle(165, 580, Color.BLUE, 35, 4, 3);
        }
        else if(result == 2){
        //Ajouter une Vie à la liste des Vie
        }
    }
}
