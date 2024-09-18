public class Etudiant_TP1 {
    
    String nom, prenom; 
    int num, note; // Le numero, et la note (sur 20)

    public Etudiant_TP1(String nom, String prenom, int num, int note) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.note = note;
    }

    public static void afficher(Etudiant_TP1 etu) {
        String rendu = "Nom : " + etu.nom + ", Prenom : " + etu.prenom + ", (Numéro d'étudiant " + etu.num + " ), Note : " + etu.note;
        System.out.println(rendu);
    }

    public static boolean estAdmis(Etudiant_TP1 etu) {
        return (etu.note >= 10);
    }

    public static String mention(Etudiant_TP1 etu) {
        int n = etu.note;
        String mention;
        if (n >= 16) {mention = "Très bien";}
        else if (n < 16 && n >= 14) {mention = "Bien";}
        else if (n < 14 && n >= 12) {mention = "Assez bien";} 
        else if (n < 12 && n >= 10) {mention = "Passable";} 
        else {mention = "Ajourné";}

        return mention;
    }
}
