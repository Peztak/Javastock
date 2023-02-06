import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            // étape 1: charger la classe de driver
            Class.forName("com.mysql.jdbc.Driver");
            // étape 2: créer l'objet de connexion
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
            System.out.println(connexion);

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