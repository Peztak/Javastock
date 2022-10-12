public class Main 
{
    //Classe article
    static class Article {
        private String libellé;
        private char categorie;

    //setters
        public Article(String libellé, char categorie ){
            this.libellé = libellé;
            this.categorie = categorie;
        }

    //getters
        public String libellé(){
            return libellé;
        }

        public String categorie(){
            return categorie;
        }

    //methode consultation 

    }

//Classe fille textile
    static class Textile extends Article {
        private String taille;
        private String couleur;
    //seters 
        public Textile(String libellé, char categorie, String taille, String couleur){
            super(libellé, categorie);
            this.taille = taille;
            this.couleur = couleur;
        }
    
    //getters 
        public String taille(){
            return taille;
        }

        public String couleur(){
            return couleur;
        }
    }

//Class fille Boisson
    static class Boisson extends Article{
        private int volume;
    //seters 
        public Boisson(String libellé, char categorie, int volume){
            super(libellé, categorie);
            this.volume = volume;
        }
        
    //getters
        public int volume(){
            return volume;
        }
    }

//Class fille Denrée Sèche
    static class DenréeSèche extends Article{
        private int poids;
    //seters 
        public DenréeSèche(String libellé, char categorie, int poids){
            super(libellé, categorie);
            this.poids = poids;
        }
        
    //getters
        public int poids(){
            return poids;
        }
    }
}