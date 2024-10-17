import java.util.ArrayList;

public class EtatJeu {
    private ArrayList<Personnage> etat;

    // Constructeur par défaut
    public EtatJeu() {
        etat = new ArrayList<>();
    }

    // Constructeur avec une liste de personnages
    public EtatJeu(ArrayList<Personnage> etat) {
        this.etat = etat;
    }

    // Méthode pour ajouter un personnage à l'état du jeu
    public void ajouterPersonnage(Personnage personnage) {
        etat.add(personnage);
    }

    // Méthode pour obtenir la liste des personnages
    public ArrayList<Personnage> getEtat() {
        return etat;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EtatJeu autreEtat = (EtatJeu) obj;

        if (etat.size() != autreEtat.etat.size()) return false;

        for (int i = 0; i < etat.size(); i++) {
            if (!etat.get(i).equals(autreEtat.etat.get(i))) {
                return false;
            }
        }
        return true;
    }
}


