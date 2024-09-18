public class Trio {
    
    private Etudiant[] membres;

    public Trio(Etudiant e1, Etudiant e2, Etudiant e3) {
        this.membres = new Etudiant[3];
        this.membres[0] = e1;
        this.membres[1] = e2;
        this.membres[2] = e3;
    }

    public Etudiant premier() {
        double note_maxi = this.membres[0].note;
        int idx_etu_maxi = 0;
        for (int i = 0; i < this.membres.length; i++) {
            if (this.membres[i].note > note_maxi) {
                note_maxi = this.membres[i].note;
                idx_etu_maxi = i;            
            }
        }

        Etudiant eleve_premier = this.membres[idx_etu_maxi];
        return eleve_premier;
    }

    public int classement(String prenom, String nom) {
        Etudiant etu_verif = null;
        for (Etudiant etu : this.membres) {
            if (etu.nom.equals(nom) && etu.prenom.equals(prenom)) {
                etu_verif = etu;
            }
        }

        if (etu_verif == null) {
            return 0;
        }
        
        int rang = 1;
        double etu_verif_note = etu_verif.note;
        for (Etudiant etu : this.membres) {
            if (etu.note > etu_verif_note) {
                rang += 1;
            }
        }

        return rang;


    }

    public double moyene() {
        double somme = 0;
        for (Etudiant etu : this.membres) {
            somme += etu.note;
        }

        double moyenne = somme / this.membres.length;
        return moyenne;
    }

    public boolean meuilleurQueLaMoyenne() {
        double note_promo = Etudiant.moyenne();
        double note_trio = this.moyene();
        boolean rendue = (note_trio > note_promo);

        return rendue;
    }


}
