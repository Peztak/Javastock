import java.awt.Dimension;
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Javastock {

  public static void main(String[] args) {
    JFrame f = new JFrame("Test JTabbedPane");
    f.setSize(1550, 800);
    JPanel pannel = new JPanel();

    JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

    JPanel onglet1 = new JPanel();
    JPanel boutons1 = new JPanel();
    JLabel titreOnglet1 = new JLabel("<html>JAVASTOCK<br><br>Texte pour l'acceuil</html>", JLabel.CENTER);
    JButton btn1 = new JButton("Bouton 1");
    JButton btn2 = new JButton("Bouton 2");
    boutons1.add(btn1);
    boutons1.add(btn2);
    onglet1.setLayout(new GridLayout(4, 1));
    onglet1.add(titreOnglet1);
    onglet1.add(boutons1);
    onglet1.setPreferredSize(new Dimension(1550, 800));
    onglets.addTab("Acceuil", onglet1);

    JPanel onglet2 = new JPanel();
    JLabel titreOnglet2 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter, modifier, creer et supprimer les articles</html>", JLabel.CENTER);
    onglet2.add(titreOnglet2);
    onglets.addTab("Article", onglet2);

    JPanel onglet3 = new JPanel();
    JLabel titreOnglet3 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter les ruptures et les reaprovisionnements en cours</html>", JLabel.CENTER);
    onglet3.add(titreOnglet3);
    onglets.addTab("Rupture et reaprovisionnement", onglet3);

    JPanel onglet4 = new JPanel();
    JLabel titreOnglet4 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter, creer et supprimer les coureurs</html>", JLabel.CENTER);
    onglet4.add(titreOnglet4);
    onglets.addTab("Coureur", onglet4);

    JPanel onglet5 = new JPanel();
    JLabel titreOnglet5 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter, creer et supprimer les epreuves</html>", JLabel.CENTER);
    onglet5.add(titreOnglet5);
    onglets.addTab("Epreuve", onglet5);

    JPanel onglet6 = new JPanel();
    JLabel titreOnglet6 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter, modifier, creer et supprimer les reservations</html>", JLabel.CENTER);
    onglet6.add(titreOnglet6);
    onglets.addTab("Reservation", onglet6);

    JPanel onglet7 = new JPanel();
    JLabel titreOnglet7 = new JLabel("<html>JAVASTOCK<br><br>Texte pour presenter l'historique des actions sur le site</html>", JLabel.CENTER);
    onglet7.add(titreOnglet7);
    onglets.addTab("Historique", onglet7);

    onglets.setOpaque(true);
    pannel.add(onglets);
    f.getContentPane().add(pannel);
    f.setVisible(true);

  }
}