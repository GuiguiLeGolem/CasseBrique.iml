import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener, MouseListener {

    public static final int largeur = 500;
    public static final int hauteur = 700;

    protected Barre barre;
    protected Balle balle;
    protected int vitesseHorizontalBarre = 10;

    JFrame fenetre = new JFrame();

    public CasseBrique(int largeur, int hauteur) throws InterruptedException {

        this.setSize(largeur,hauteur);
        setBounds(0,0,largeur,hauteur);


        JPanel panneau = (JPanel)fenetre.getContentPane();
        panneau.setSize(largeur,hauteur);
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        this.createBufferStrategy(2);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        //panneau.addMouseListener(this);

        this.demarrer();

    }

    public void demarrer() throws InterruptedException {
        try{
            balle = new Balle(165, 580, Color.BLUE, 35, 4, 3);
            barre = new Barre(185, 620, Color.ORANGE, 125, 20);

            ArrayList<Brique> listBrique = new ArrayList<>();

            listBrique.add(new Brique(300, 150, Color.BLACK, 50, 50));
            listBrique.add(new Brique(250, 150, Color.BLACK, 49, 49));
            listBrique.add(new Brique(200, 150, Color.BLACK, 49, 49));

            ArrayList<Vie> laVie = new ArrayList<>();

            laVie.add(new Vie(450, 25, Color.RED, 25));
            laVie.add(new Vie(420, 25, Color.RED, 25));
            laVie.add(new Vie(390, 25, Color.RED, 25));

            while(true) {

                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

                //----------------------

                dessin.setColor(Color.white);
                dessin.fillRect(0,0,largeur,hauteur);

                balle.dessiner(dessin);
                balle.deplacement();
                balle.testCollision();
                balle.rebond(barre);

                barre.dessiner(dessin);
                barre.testCollision();

                for (Brique brique: listBrique) {
                    brique.dessiner(dessin);
                }

                for (Vie vie: laVie) {
                    vie.dessiner(dessin);
                }

                //------------------------
                dessin.dispose();
                getBufferStrategy().show();
                Thread.sleep(1000 / 60); // Pour avoir une vitesse adéquat
            }
        }
        catch (InterruptedException InEx){

        }
    }

    public void recommencer(){

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_LEFT:
                //barre.deplacement(false);
                barre.positionX -= vitesseHorizontalBarre;
                break;
            case KeyEvent.VK_RIGHT :
                //barre.deplacement(true);
                barre.positionX += vitesseHorizontalBarre;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            this.demarrer();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
