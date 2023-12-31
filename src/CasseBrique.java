import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener, MouseListener {

    public static final int largeur = 500;
    public static final int hauteur = 700;

    protected Barre barre;
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
            barre = new Barre(185, 620, Color.ORANGE, 125, 20);

            ArrayList<Balle> lesBalles = new ArrayList<>();

            lesBalles.add(new Balle(165, 580, Color.BLUE, 35, 7, 4));

            ArrayList<Brique> listeBrique = new ArrayList<>();
            ArrayList<Bonus> lesBonus = new ArrayList<>();

            lesBonus.add(new Bonus( 400, 150, Color.CYAN, 45, 45));
            listeBrique.add(new Brique(400, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(350, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(300, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(250, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(200, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(150, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(100, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique( 50, 150, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(400, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(350, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(300, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(250, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(200, 100, Color.BLACK, 45, 45));

            lesBonus.add(new Bonus( 150, 100, Color.CYAN, 45, 45));//

            listeBrique.add(new Brique(150, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(100, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique( 50, 100, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(400, 200, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(350, 200, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(300, 200, Color.BLACK, 45, 45));

            lesBonus.add(new Bonus( 250, 200, Color.CYAN, 45, 45));//

            listeBrique.add(new Brique(250, 200, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(200, 200, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(150, 200, Color.BLACK, 45, 45));
            listeBrique.add(new Brique(100, 200, Color.BLACK, 45, 45));

            lesBonus.add(new Bonus( 50, 200, Color.CYAN, 45, 45));//

            listeBrique.add(new Brique( 50, 200, Color.BLACK, 45, 45));

            ArrayList<Vie> laVie = new ArrayList<>();

            laVie.add(new Vie(450, 25, Color.RED, 25));
            laVie.add(new Vie(420, 25, Color.RED, 25));
            laVie.add(new Vie(390, 25, Color.RED, 25));

            while(true) {
                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

                //----------------------

                dessin.setColor(Color.white);
                dessin.fillRect(0,0,largeur,hauteur);

                for (Balle balle: lesBalles){

                    balle.deplacement();
                    balle.dessiner(dessin);
                    balle.testCollision();
                    balle.rebond(barre);
                    balle.detruitBrique(listeBrique, lesBonus); //si une balle touche une brique : la brique meurt

                    if(balle.positionY >= 700 - balle.diametre){
                        if(!laVie.isEmpty()){
                            laVie.remove(laVie.getLast());
                            balle.setPositionX(165);
                            balle.setPositionY(580);
                        }
                    }
                }

                barre.dessiner(dessin);
                barre.testCollision();
                barre.colisionBonus(lesBonus);

                for(Bonus bonus: lesBonus){
                    bonus.dessiner(dessin);
                }

                for (Brique brique: listeBrique) {
                    brique.dessiner(dessin);
                }

                for(Bonus bonus: lesBonus){
                    bonus.deplacement();
                }

                for (Vie vie: laVie) {
                    vie.dessiner(dessin);
                }

                //------------------------
                dessin.dispose();
                getBufferStrategy().show();
                Thread.sleep(1000 / 60); // Pour avoir une vitesse adéquat

                if(laVie.isEmpty()){
                    break;
                }
                else if (listeBrique.isEmpty()){
                    break;
                }
            }
        }
        catch (InterruptedException InEx) {
            throw new RuntimeException(InEx);
        }

        recommencer();
    }

    public void recommencer() throws InterruptedException {

        int result = JOptionPane.showConfirmDialog((Component) null, "Voulez-vous réessayer ?", "GAME OVER", JOptionPane.OK_CANCEL_OPTION);

        if(result == 0){
            demarrer();
        }
        else {
            fenetre.dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
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
                barre.deplacementGauche();
                break;
            case KeyEvent.VK_RIGHT :
                barre.deplacementDroite();
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
