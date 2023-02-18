import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Javastock {

  public static void main(String[] args) {
    try {
      /*
       * Téléchargez le fichier mysql-connector8.0.32.jar sur
       * https://dev.mysql.com/downloads/connector/j/?os=26
       * (Pour Linux)
       * Crée un dossier lib du projet Java courant !
       * 1.export CLASSPATH=$CLASSPATH:/chemin/vers/mysql-connector-j-8.0.32.jar
       * ou
       * Inconvénients : Chaque execution !
       * 2. java -cp ~/Documents/GitHub/Javastock/lib/mysql-connector-j-8.0.32.jar
       * Database.java
       * 4.javac Database.java 'Compilation du code Java'
       * 5.java Database 'Execution de la class Database'
       */
      Class.forName("com.mysql.cj.jdbc.Driver");
      // étape 2: créer l'objet de connexion
      Connection connexion = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/webcourses",
          "esiounath",
          "eden");
      // créer l'objet statement
      Statement statement = connexion.createStatement();
      // exécuter la requête SELECT
      ResultSet resultat = statement.executeQuery("SELECT * FROM inscription");
      // parcourir les résultats
      while (resultat.next()) {
        // Remplacer le string par la colonne de la table qui doit être au format
        // String(Varchar)
        String[] champ1 = { resultat.getString("day"), resultat.getString("IP") };
        for (int i = 0; i < champ1.length; i++) {
          System.out.println(champ1[i]);
        }
      }
      JFrame f = new JFrame("Test JTabbedPane");
      f.setSize(1550, 800);
      JPanel pannel = new JPanel();

      JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
      // Bonjour Monsieurs Bruno & Cderick
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
      JLabel titreOnglet2 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter, modifier, creer et supprimer les articles</html>",
          JLabel.CENTER);
      onglet2.add(titreOnglet2);
      onglets.addTab("Article", onglet2);

      JPanel onglet3 = new JPanel();
      JLabel titreOnglet3 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter les ruptures et les reaprovisionnements en cours</html>",
          JLabel.CENTER);
      onglet3.add(titreOnglet3);
      onglets.addTab("Rupture et reaprovisionnement", onglet3);

      JPanel onglet4 = new JPanel();
      JLabel titreOnglet4 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter, creer et supprimer les coureurs</html>", JLabel.CENTER);
      onglet4.add(titreOnglet4);
      onglets.addTab("Coureur", onglet4);

      JPanel onglet5 = new JPanel();
      JLabel titreOnglet5 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter, creer et supprimer les epreuves</html>", JLabel.CENTER);
      onglet5.add(titreOnglet5);
      onglets.addTab("Epreuve", onglet5);

      JPanel onglet6 = new JPanel();
      JLabel titreOnglet6 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter, modifier, creer et supprimer les reservations</html>",
          JLabel.CENTER);
      onglet6.add(titreOnglet6);
      onglets.addTab("Reservation", onglet6);

      JPanel onglet7 = new JPanel();
      JLabel titreOnglet7 = new JLabel(
          "<html>JAVASTOCK<br><br>Texte pour presenter l'historique des actions sur le site</html>", JLabel.CENTER);
      onglet7.add(titreOnglet7);
      onglets.addTab("Historique", onglet7);

      onglets.setOpaque(true);
      pannel.add(onglets);
      f.getContentPane().add(pannel);
      f.setVisible(true);
      // fermer les objets de connexion
      resultat.close();
      statement.close();
      connexion.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
