import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {
    public Test() throws HeadlessException {
        setSize(500,500);
        JPanel panneau = new JPanel();
        setContentPane(panneau);
        JButton button = new JButton("Clic bro");
        panneau.add(button);

        button.addActionListener((e) -> {
            System.out.println("toto");
        });
    }

    //public class Click implements ActionListener{
    //    @Override
    //    public void actionPerformed(ActionEvent e) {
    //        System.out.println("get clicked kiddo");
    //    }
    //}

    public static void main(String[] args) {
        new Test();
    }
}
