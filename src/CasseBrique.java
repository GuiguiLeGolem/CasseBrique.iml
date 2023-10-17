import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CasseBrique extends Canvas implements KeyListener, MouseListener {

    public static final int largeur = 500;
    public static final int hauteur = 700;

    protected Barre barre;

    JFrame fenetre = new JFrame();

    public CasseBrique() throws InterruptedException {

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

        Balle balle = new Balle();
        barre = new Barre(185, 620, 7, Color.ORANGE, 125, 20);

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

            //------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_LEFT:
                barre.deplacement(false);
                System.out.println("debug : LEFT");
                break;
            case KeyEvent.VK_RIGHT :
                barre.deplacement(true);
                System.out.println("debug : RIGHT");
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
