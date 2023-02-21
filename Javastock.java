import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.regex.*;  
import java.text.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
/*
 * export CLASSPATH=$CLASSPATH:~/Documents/Javastock/lib/mysql-connector-j-8.0.32.jar && source ~/.bashrc
 * ou 
 * java cp ~/Documents/Javastock/lib/mysql-connector-j-8.0.32.jar Javastock.java
 * Crée le dossier lib dans le répertoire courant du projet 
 * 
 */
public class Javastock extends JFrame {
        //JComboBox<String> comboBox = new JComboBox<>(Requests("SELECT * FROM inscription","IP"));
        private static final String DB_URL = "jdbc:mysql://localhost:3306/webcourses";
        private static final String DB_USER = "esiounath";
        private static final String DB_PASSWORD = "eden";
        public static Connection Connexion() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
            throw e;
        }
        return connection;
    }  
        public String[] Requests(String Requests,String Colonne) {
            ArrayList<String> results = new ArrayList<>();
            try {
                Connection connection = Connexion();
                Statement statement = connection.createStatement();
                ResultSet resultat = statement.executeQuery(Requests);
                while (resultat.next()) {
                    String row = resultat.getString(Colonne);
                    results.add(row);
        
                }
            }catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return results.toArray(new String[0]);
        }
        private static final long serialVersionUID = 1L;
        private static final Font font = new Font("Arial", Font.PLAIN, 18); // Créer une police avec Arial, taille 14 et style normal
        private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        public String[] creerListeDeroulanteDate(int Year) {
            String[] dates = new String[Year * 365];
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < dates.length; i++) {
                Date date = calendar.getTime();
                String dateString = dateFormat.format(date);
                dates[i] = dateString;
                calendar.add(Calendar.DATE, 1);
            }
            return dates;
        }
        public String[] creerListeDeroulanteDateNaissance() {
            Calendar calendar = Calendar.getInstance();
            String[] dates = new String[365 * 102]; // 102 années (depuis 1920 jusqu'à maintenant)
            calendar.set(1920, Calendar.JANUARY, 1); // fixer la date de départ
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < dates.length; i++) {
            Date date = calendar.getTime();
            String dateString = dateFormat.format(date);
            dates[i] = dateString;
            calendar.add(Calendar.DATE, 1);
            }
            return dates;
            }
        public void CreateReservation(JPanel panel) {
            int screenWidth = (int) screenSize.getWidth();
            int screenHeight = (int) screenSize.getHeight();
            JComboBox<String> coureur = new JComboBox<>(Requests("SELECT * FROM coureur","co_prenom"));
            JComboBox<String> type_epreuve = new JComboBox<>(Requests("SELECT * FROM type_epreuve","typep_nom"));
            JComboBox<String> date = new JComboBox<>(creerListeDeroulanteDate(10));
            JList<String> article_id = new JList<>(Requests("SELECT id FROM article ","id"));
            JList<String> article_libelle = new JList<>(Requests("SELECT libelle FROM article ","libelle"));
            JList<String> quantite = new JList<>(Requests("SELECT quantite FROM reservation ","quantite"));

        
           JLabel[] Label = {new JLabel("Date:"),new JLabel("Coureur:"),new JLabel("Type d'épreuve:"),new JLabel("Article")};
           JScrollPane[] scrollId = {new JScrollPane(article_id),new JScrollPane(article_libelle)};
            // Affiche la JComboBox
            JPanel comboBoxPanel = new JPanel();
            comboBoxPanel.setPreferredSize(new Dimension(screenWidth / 3, screenHeight / 3));
            comboBoxPanel.setLayout(new GridLayout(10, 10)); // Affiche les deux JComboBox en colonne
            comboBoxPanel.add(Label[0]);
            comboBoxPanel.add(date);
            comboBoxPanel.add(Label[1]);
            Label[0].setFont(font); // Changer la police pour le menu
            Label[1].setFont(font); // Changer la police pour le menu
            Label[2].setFont(font); // Changer la police pour le menu
            comboBoxPanel.add(coureur);
            comboBoxPanel.add(Label[2]);
            comboBoxPanel.add(type_epreuve);
            comboBoxPanel.add(Label[3]);
            comboBoxPanel.add(scrollId[0]);
            comboBoxPanel.add(scrollId[1]);
        
            // Affiche la boîte de dialogue avec le JPanel contenant les deux JComboBox
            int result = JOptionPane.showConfirmDialog(panel, comboBoxPanel, "Nouvelle réservation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            // Vérifie si l'utilisateur a cliqué sur le bouton OK
            if (result == JOptionPane.OK_OPTION) {
                // Récupère les valeurs sélectionnées dans les deux JComboBox
             String[] Information = {(String) date.getSelectedItem(),(String) coureur.getSelectedItem()};
                // Fait quelque chose avec les valeurs récupérées
                // ...
            }
        }
        public void AjouterCoureurNew(JPanel panel){
            try{
                JPanel comboBoxPanel = new JPanel();
                int screenWidth = (int) screenSize.getWidth();
                int screenHeight = (int) screenSize.getHeight();          
                comboBoxPanel.setPreferredSize(new Dimension(screenWidth / 3, screenHeight / 3));
                comboBoxPanel.setLayout(new GridLayout(10, 10)); // Affiche les deux JComboBox en colonne
                JTextField nom_coureur = new JTextField("Nom");
                JTextField prenom_coureur = new JTextField("Prenom");
                JComboBox<String> date_naissance = new JComboBox<>(creerListeDeroulanteDateNaissance());
                JTextField adresse_coureur = new JTextField("Adresse");
                JTextField nationalite_coureur = new JTextField("Nationalité");
                JComboBox<String> sexe_coureur = new JComboBox<>(new String[]{"1", "2"});
                JTextField numero_coureur = new JTextField("Numéro de téléphone : 0659...");
                JTextField email_coureur = new JTextField("Email");
                JComboBox <String> status_coureur = new JComboBox<>(new String[]{"A","P"});
                nom_coureur.setBounds(20,50,screenWidth / 4,30);
                prenom_coureur.setBounds(20,50,screenWidth / 4,30);
                adresse_coureur.setBounds(20,50,screenWidth / 4,30);
                nationalite_coureur.setBounds(20,50,screenWidth / 4,30);//creerListeDeroulanteDateNaissance(int Year)
                numero_coureur.setBounds(20,50,screenWidth / 4,30);
                email_coureur.setBounds(20,50,screenWidth / 4,30);
                JLabel[] Label = {new JLabel("Nom :"),new JLabel("Prenom :"),new JLabel("Adresse :"),new JLabel("Date de \n Naissance :"),new JLabel("Nationalité"),
                new JLabel("Sexe :"),new JLabel("Numéro téléphone :"),new JLabel("Email :"),new JLabel("Status :")};
                comboBoxPanel.add(Label[0]);
                comboBoxPanel.add(nom_coureur);
                comboBoxPanel.add(Label[1]);
                comboBoxPanel.add(prenom_coureur);
                comboBoxPanel.add(Label[2]);
                comboBoxPanel.add(adresse_coureur);
                comboBoxPanel.add(Label[3]);
                comboBoxPanel.add(date_naissance);
                comboBoxPanel.add(Label[4]);
                comboBoxPanel.add(nationalite_coureur);
                comboBoxPanel.add(Label[5]);
                comboBoxPanel.add(sexe_coureur);
                comboBoxPanel.add(Label[6]);
                comboBoxPanel.add(numero_coureur);
                comboBoxPanel.add(Label[7]);
                comboBoxPanel.add(email_coureur);
                comboBoxPanel.add(Label[8]);
                comboBoxPanel.add(status_coureur);
                // Affiche la boîte de dialogue avec le JPanel contenant les deux JComboBox
                int result = JOptionPane.showConfirmDialog(panel, comboBoxPanel, "Ajouter Nouveau Coureur", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                // Vérifie si l'utilisateur a cliqué sur le bouton OK
                if (result == JOptionPane.OK_OPTION) {
                    String [] text = {nom_coureur.getText(),prenom_coureur.getText(),adresse_coureur.getText(),nationalite_coureur.getText(),
                        numero_coureur.getText(),email_coureur.getText()
                    };
                    text[0].replaceAll("\\s", "");
                    text[1].replaceAll("\\s", "");
                    text[3].replaceAll("\\s", "");
                    text[4].replaceAll("\\s", "");
                    text[5].replaceAll("\\s", "");
                 String[] Selection = {(String) status_coureur.getSelectedItem(),(String) sexe_coureur.getSelectedItem(),(String) date_naissance.getSelectedItem()};
                 JPanel AlertBox = new JPanel();
                 JLabel AlertMessage = new JLabel();
                 AlertBox.setPreferredSize(new Dimension(screenWidth / 4, screenHeight / 4));
                 HashMap<String, String> PatternDictionnary = new HashMap<String, String>() {{
                    put("email", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                    put("PersonnalData", "^[A-Za-z]{4,}$");
                    put("address", "^[0-9]+\\s?[a-zA-Z]+\\s?([a-zA-Z]|[a-zA-Z])+(\\s+ | [a-zA-Z0-9-]+)+$");
                    put("citizen", "^[a-zA-Z]+$");
                    put("phoneNumber", "^\\d{10}$");
                }};
                 if(Pattern.matches(PatternDictionnary.get("email"),text[5]) && Pattern.matches(PatternDictionnary.get("PersonnalData"),text[0]) &&  Pattern.matches(PatternDictionnary.get("PersonnalData"),text[1]) && Pattern.matches(PatternDictionnary.get("address"),text[2]) && Pattern.matches(PatternDictionnary.get("citizen"),text[3]) && Pattern.matches(PatternDictionnary.get("phoneNumber"),text[4])){ //[^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$]
                 String sql = "INSERT INTO coureur VALUES (7, ?, ?, ?, ?, ?, ?, ? , ?, ?)";
                 Connection connection = Connexion();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 statement.setString(1, text[0]);
                 statement.setString(2, text[1]);
                 statement.setString(3, text[2]);
                 statement.setString(4, Selection[2]);
                 statement.setString(5, text[3]);
                 statement.setInt(6, Integer.parseInt(Selection[1]));
                 statement.setInt(7, Integer.parseInt(text[4]));
                 statement.setString(8, text[5]);
                 statement.setString(9, Selection[0]);
                 statement.executeUpdate();
                 AlertMessage.setText("Coureur Ajouté");
                 JOptionPane.showConfirmDialog(panel, AlertBox, "Envoi effectuer", JOptionPane.OK_CANCEL_OPTION);

                 }else{
                    if(Pattern.matches(PatternDictionnary.get("email"),text[5]) || Pattern.matches(PatternDictionnary.get("PersonnalData"),text[0]) ||  Pattern.matches(PatternDictionnary.get("PersonnalData"),text[1]) || Pattern.matches(PatternDictionnary.get("adress"),text[2]) || Pattern.matches(PatternDictionnary.get("citizen"),text[3]) || Pattern.matches(PatternDictionnary.get("phoneNumber"),text[4])){
                        AlertMessage.setText("Erreur Formulaire Veuilles saisr correcment vos informations !");
                        AlertBox.add(AlertMessage);
                        JOptionPane.showConfirmDialog(panel, AlertBox, "Erreur du formulaire", JOptionPane.OK_CANCEL_OPTION);

                    }
                 }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    public Javastock() {
        super("JavaStock");
        // Crée un JPanel pour contenir les composants de l'interface utilisateur
        JPanel panel = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtenir la hauteur et la largeur de l'écran
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Crée une instance de JMenuBar
        JMenuBar menuBar = new JMenuBar();
        // Crée un menu "Fichier"
        JMenu reservation = new JMenu("Réservation");
        JMenu Acceuille = new JMenu("Principal");
        JMenu Coureur = new JMenu("Coureur");
        JMenu Historique = new JMenu("Historique");
        JMenu Article_rupture = new JMenu("Article en rupture");
        JMenu Article = new JMenu("Article");
        JMenu Type_E = new JMenu("Type d'épreuve");
        reservation.setHorizontalAlignment(JMenu.CENTER); // Centrer le menu
        Acceuille.setHorizontalAlignment(JMenu.CENTER); // Centrer le menu
        reservation.setFont(font); // Changer la police pour le menu
        Acceuille.setFont(font); // Changer la police pour le menu
        Coureur.setFont(font);
        Article.setFont(font);
        Type_E.setFont(font);
        // Crée des éléments de menu pour le menu "Fichier"
        JMenuItem CreateResa = new JMenuItem("Crée");
        JMenuItem UpdateResa = new JMenuItem("Modifiez");
        JMenuItem CheckResa = new JMenuItem("Consulter");
        JMenuItem DeleteResa = new JMenuItem("Supprimez");
        JMenuItem CancelResa = new JMenuItem("Annulez");
        JMenuItem CreateArticle = new JMenuItem("Crée ");
        JMenuItem UpdateArticle = new JMenuItem("Modifiez");
        JMenuItem CheckArticle = new JMenuItem("Consulter");
        JMenuItem DeleteArticle = new JMenuItem("Supprimez");
        JMenuItem AjouterCoureur = new JMenuItem("Ajouter");
        JMenuItem AjouterType_E = new JMenuItem("Ajouter");

        CreateResa.setFont(font); // Changer la police pour le menu
        UpdateResa.setFont(font); // Changer la police pour le menu
        CheckResa.setFont(font); // Changer la police pour le menu
        AjouterType_E.setFont(font);
        DeleteResa.setFont(font); // Changer la police pour le menu
        CancelResa.setFont(font);
        CreateArticle.setFont(font); // Changer la police pour le menu
        UpdateArticle.setFont(font); // Changer la police pour le menu
        CheckArticle.setFont(font); // Changer la police pour le menu
        DeleteArticle.setFont(font); // Changer la police pour le menu
        AjouterCoureur.setFont(font);
        Historique.setFont(font);
        Article_rupture.setFont(font);
        Acceuille.setFont(font); // Changer la police pour le menu
        Article.add(CreateArticle);
        Article.add(UpdateArticle);
        Article.add(CheckArticle);
        Article.add(DeleteArticle);
        // Ajoute les éléments de menu au menu "Fichier"
        reservation.add(CreateResa);
        reservation.add(UpdateResa);
        reservation.add(CheckResa);
        //reservation.addSeparator(); // Ajoute un séparateur entre les éléments
        reservation.add(DeleteResa);
        reservation.add(CancelResa);
        Type_E.add(AjouterType_E);
        Coureur.add(AjouterCoureur);

        // Ajoute le menu "Fichier" à la barre de menus
        menuBar.add(Acceuille);
        menuBar.add(Article);
        menuBar.add(Coureur);
        menuBar.add(Type_E);
        menuBar.add(reservation);
        menuBar.add(Article_rupture);
        menuBar.add(Historique);

// Ajoute un ActionListener à l'élément de menu "Nouveau"
CreateResa.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        CreateReservation(panel);
    }
});
AjouterCoureur.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        AjouterCoureurNew(panel);
    }
});
        // Ajoute la barre de menus à la fenêtre
        setJMenuBar(menuBar);

        // Ajoute le JPanel à la fenêtre
        getContentPane().add(panel);

        // Définit la taille de la fenêtre et l'affiche
        this.setSize(screenWidth / 2, screenHeight / 2);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Javastock();
    }
}