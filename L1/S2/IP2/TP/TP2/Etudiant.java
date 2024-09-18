public class Etudiant {
    
    final String nom, prenom; 
    double note; // Le numero, et la note (sur 20)
    int num;

    static int nombreDEtudiants = 0; // nb etudiant dans la promo
    static double sommeDesNotes = 0; //somme des notes DES etudiants


    // Jai garder ce constructeur avec num meme si num n'est nul aprt dans l'exo 1 du TP2 car sinon
    // Il y'aurais eu 2 constructeur avec une meme signature
    public Etudiant(String nom, String prenom, double note, int num) {
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
        this.num = num;
    }

    public Etudiant(String prenom, String nom, double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;

        nombreDEtudiants += 1;
        sommeDesNotes += (double) note;
    }


    public void afficher() {
        String rendu =  this.nom + " " + this.prenom + " : " + this.note;
        System.out.println(rendu);
    }

    public static void afficher2(Etudiant etu) {
        String rendu =  etu.nom + " " + etu.prenom + " : " + etu.note;
        System.out.println(rendu);
    }

    public boolean estAdmis() {
        return (this.note >= 10);
    }

    public static double moyenne() {
        double moyenne_pondere = sommeDesNotes / nombreDEtudiants;
        return moyenne_pondere;
    }

    public boolean meuilleurQueLaMoyenne() {
        double etus_moyenne = Etudiant.moyenne();
        double etu_note = (double) this.note;
        
        boolean rendue = (etu_note > etus_moyenne);
        return rendue;
    }

    public void modifierNote(double nouvelleNote) {
        
        sommeDesNotes -= this.note; // faut pas oublier sa..
        this.note = nouvelleNote;
        sommeDesNotes += this.note; // et sa ausssi0

    }

    public static String mention(Etudiant etu) {
        int n = (int) etu.note;
        String memtion;
        if (n >= 16) {mention = "Très bien";}
        else if (n < 16 && n >= 14) {mention = "Bien";}
        else if (n < 14 && n >= 12) {mention = "Assez bien";} 
        else if (n < 12 && n >= 10) {mention = "Passable";} 
        else {mention = "Ajourné";}

        return mention;
    }


}
