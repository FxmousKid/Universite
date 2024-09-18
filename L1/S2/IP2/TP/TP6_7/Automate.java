public class  Automate{
    public Cellule premiere;
    public Cellule derniere;

    public Automate(String str) {
        // Takes a String of Cellules, and creates a list accordingly
        for (int idx = 0; idx < str.length(); idx++) {
            if (str.charAt(idx) != '#' && str.charAt(idx) != '-') {
                System.out.println("\n ! ! ! ! Invalid Automate ! ! ! !\n");
                break ;
            }
            this.ajoutFin(str.charAt(idx) == '#');
        }
    }

    public void ajoutDebut(boolean noire) {
        
        Cellule new_debut = new Cellule(noire);
        
        // Check if list is empty :
        // dans le cas de figure ou la liste etait vide, on veut que this.derniere et
        // this.premiere pointe au meme endroit.
        if (this.premiere == null && this.derniere == null) { 
            this.premiere = new_debut;
            this.derniere = new_debut;
            return ;
        }
        new_debut.setPrecedente(null); // oui, c'est initaliser a null, mais c'est bien d'etre explicit
        new_debut.setSuivante(this.premiere);
        this.premiere.setPrecedente(new_debut);
        this.premiere = new_debut;
        return ;
    }


    public void ajoutFin(boolean noire) {
        Cellule new_fin = new Cellule(noire);

        // check if the array is empty
        if (this.derniere == null && this.derniere == null) {
            this.derniere = new_fin;
            this.premiere = new_fin;
            return ;
        }
        new_fin.setPrecedente(this.derniere);
        new_fin.setSuivante(null);
        this.derniere.setSuivante(new_fin);
        this.derniere = new_fin;
        return ; 
     }

    public void Affichage() {
        // Fonction qui affiche les valeurs des Cellues de la liste
        Cellule cell_tmp;

        cell_tmp = this.premiere;
        while (cell_tmp != null) {
            cell_tmp.afficher();
            cell_tmp = cell_tmp.getSuivante();  
        }
    }

    public boolean Unanimite(Cellule c1, Cellule c2, Cellule c3) {
        boolean val_1;
        boolean val_2;
        boolean val_3;

        val_1 = (c1 == null) ? false : c1.getNoire();
        val_2 = (c2 == null) ? false : c2.getNoire();
        val_3 = (c3 == null) ? false : c3.getNoire();

        return !(val_1 == val_2 && val_1 == val_3 && val_2 == val_3);
    }
    
    
    public boolean Majorite(Cellule c1, Cellule c2, Cellule c3) {
        boolean val_1;
        boolean val_2;
        boolean val_3;

        val_1 = (c1 == null) ? false : c1.getNoire();
        val_2 = (c2 == null) ? false : c2.getNoire();
        val_3 = (c3 == null) ? false : c3.getNoire();
    
        return (val_1 == val_2 ? val_1 : val_3);
    }


    public void prochaineEtapeUnanimite() {
        Cellule cell_tmp;

        // Check if the list is empty
        if (this.premiere == null && this.derniere == null) {
            return ;
        }   
        cell_tmp = this.premiere;
        while (cell_tmp != null) {
            cell_tmp.setProchaineEtat(Unanimite(
                cell_tmp.getPrecedente(),
                cell_tmp,
                cell_tmp.getSuivante()));  
            cell_tmp = cell_tmp.getSuivante();
        }
    }

    public void prochaineEtapeMajorite() {
        Cellule cell_tmp;

        // Check if the list is empty
        if (this.premiere == null && this.derniere == null) {
            return ;
        }   
        cell_tmp = this.premiere;
        while (cell_tmp != null) {
            cell_tmp.setProchaineEtat(Majorite(
                cell_tmp.getPrecedente(),
                cell_tmp,
                cell_tmp.getSuivante()));  
            cell_tmp = cell_tmp.getSuivante();
        }
    }

    public void miseAJour() {
        Cellule cell_tmp = this.premiere;

        while (cell_tmp != null) {
            cell_tmp.setNoire(cell_tmp.getProchaineEtat());
            cell_tmp = cell_tmp.getSuivante();
        }
    }

    public void uneEtapeUnanimite() {
        this.prochaineEtapeUnanimite();
        this.miseAJour();
    }
    
    public void uneEtapeMajorite() {
        this.prochaineEtapeMajorite();
        this.miseAJour();
    }

    public void nEtapeUnanimite(int n) {
        while (n-- > 0) {
            this.uneEtapeUnanimite();
            this.Affichage();
            System.out.println();
        }
    }

    public void nEtapeMajorite(int n) {
        while (n-- > 0) {
            this.uneEtapeMajorite();
            this.Affichage();
            System.out.println();
        }
    }

    

    

}
