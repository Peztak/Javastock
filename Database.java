import java.sql.*;

class Database {
    private String password;
    private String username;
    private String host;
    private String database;
    private String port;
    private Connection connexion;

    public Database(String password, String username, String host, String database, String port) {
        this.password = password;
        this.username = username;
        this.host = host;
        this.database = database;
        this.port = port;
    }

    public Connection connexion_database() {
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
            // étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // étape 2: créer l'objet de connexion
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    this.username, this.password);
            System.out.println("Connexion établie !");
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
            // fermer les objets de connexion
            resultat.close();
            statement.close();
            connexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return connexion;
    }

    public static void main(String[] args) {
        Database connexion = new Database("eden", "esiounath", "localhost", "webcourses", "3306");
        connexion.connexion_database();
    }
}