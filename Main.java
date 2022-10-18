import javax.swing.JPanel;

public class Main 
{
    //Classe article
    static class Article {
        private String libelle;
        private char categorie;

    //setters
        public Article(String libelle, char categorie ){
            this.libelle = libelle;
            this.categorie = categorie;
        }

        public void setlibelle( String libelle){
            this.libelle = libelle;
        }

        public void setcategorie( char categorie){
            this.categorie = categorie;
        }

    //getters
        public String getlibelle(){
            return libelle;
        }

        public char getcategorie(){
            return categorie;
        }

    //methode consultation 
        public void consulterArticle(Article unarticle){
            System.out.println("Le libelle est : " + unarticle.getlibelle() + " et la catégorie est : " + unarticle.getcategorie());
        }


    }

//Classe fille d'article : textile
    static class Textile extends Article {
        private String taille;
        private String couleur;
    //seters 
        public Textile(String libelle, char categorie, String taille, String couleur){
            super(libelle, categorie);
            this.taille = taille;
            this.couleur = couleur;
        }

        public void settaille( String taille){
            this.taille = taille;
        }

        public void setcouleur( String couleur){
            this.couleur = couleur;
        }
    
    //getters 
        public String gettaille(){
            return taille;
        }

        public String getcouleur(){
            return couleur;
        }

    //Methodes
        public void afficherCarac(Textile untextile){
            System.out.println("La taille du "+ untextile.getlibelle() + " est " + untextile.gettaille() + " et la couleur est : " + untextile.getcouleur());
        }

    }

//Classe fille de Boisson
    static class Boisson extends Article{
        private int volume;
    //seters 
        public Boisson(String libelle, char categorie, int volume){
            super(libelle, categorie);
            this.volume = volume;
        }

        public void setvolume( int volume){
            this.volume = volume;
        }
        
    //getters
        public int getvolume(){
            return volume;
        }

    //methode 
        public void afficherVolume(Boisson uneboisson){
            System.out.println("Le volume de " + uneboisson.getlibelle() + " est de  " + uneboisson.getvolume() + " Centimètre cube ");
        }
    }

//Class fille d'article Denrée Sèche
    static class DenreeSeche extends Article{
        private int poids;
    //seters 
        public DenreeSeche(String libelle, char categorie, int poids){
            super(libelle, categorie);
            this.poids = poids;
        }

        public void setpoids( int poids){
            this.poids = poids;
        }
        
    //getters
        public int getpoids(){
            return poids;
        }

    //methode 
        public void afficherPoids(DenreeSeche unpoids){
            System.out.println("Le poids de " + unpoids.getlibelle() + " est de " + unpoids.getpoids() + " Kg.");
        }
    }
//Création classe Coureur
    static class Coureur {
        private String prenom;
        private String nom;

    //Setters
        public Coureur(String prenom, String nom){
            this.prenom = prenom;
            this.nom = nom;
        }
        public void setprenom( String prenom){
            this.prenom = prenom;
        }

        public void setnom( String nom){
            this.nom = nom;
        }

        //getters
        public String getPrenom(){
            return prenom;
        } 

        public String getNom(){
            return nom;
        }

        //méthodes
        public void informerCoureur(Coureur uncoureur){
            System.out.println("Le prénom du coureur est : " + uncoureur.getPrenom() + " et le nom du coureur est : " + uncoureur.getNom());
        }
    }
//Création classe Epreuve
    static class Epreuve{
        private String typep;

    //Setters 
        public Epreuve(String typep){
            this.typep = typep;
        }
        public void settypep( String typep){
            this.typep = typep;
        }

    //getters
        public String gettypep(){
            return typep;
        }

    //methodes
        public void afficherTypeEpreuve(Epreuve uneepreuve){
            System.out.println("Le type de l'épreuve est : " + uneepreuve.gettypep());
        }
    }
//Classe Historique
    static class Historique{
        private String log;
        //Setters 
        public Historique(String log){
            this.log = log;
        }

        public void setlog(String log){
            this.log = log;
        }

    //getters
        public String getlog(){
            return log;
        }

    //methodes
        public void consulterHistorique(Historique unelog){
            System.out.println("Voici l'historique récent : " + unelog.getlog());
        }
    }

//Classe réservation 
    static class Reservation {
        private String typepreuve;
        private String nomreserv;
        private String article; 

    }



    //execution prog principal

    public static void main(String[]args){
        Article article1 = new Article("Outil", 'A');
        article1.consulterArticle(article1);

        DenreeSeche article2 = new DenreeSeche("Gateaux", 'D', 12);
        article2.afficherPoids(article2);

        Boisson article3 = new Boisson("Eau", 'L', 32);
        article3.afficherVolume(article3);

        Textile article4 = new Textile("T-shirt", 'T', "Moyenne", "Bleue");
        article4.afficherCarac(article4);

        Coureur coureur1 = new Coureur("Jean", "Jacque");
        coureur1.informerCoureur(coureur1);

        Epreuve epreuve1 = new Epreuve("Course à pieds");
        epreuve1.afficherTypeEpreuve(epreuve1);

        Historique histo1 = new Historique("13h05 : Connexion de Michelle,  15h32 : connexion de Gabin");
        histo1.consulterHistorique(histo1);

    }
}
