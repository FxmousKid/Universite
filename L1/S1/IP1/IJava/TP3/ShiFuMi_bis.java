import java.lang.Math;


public class ShiFuMi_bis {
 
    ShiFuMi object = new ShiFuMi();

    public static String chifumi_choix_manches() {
        String choix_manches = System.console().readLine("Entrez le nombre de manches : ");
       
        int manches = Integer.valueOf(choix_manches);

        return ShiFuMi.chifumi(manches);
    }

    public static String chifumi_choix_victoires() {
        
        String choix_victoires = System.console().readLine("Entrez le nombre de victoires necessaire : ");
       
        // on reconvertit les input en int vu que de base choix_victoires est un String
        int victoires = Integer.valueOf(choix_victoires);

        // Statistique du jeu du joueur 1
        String victoire_count = "";
        String perte_count = "";
        String egalite_count = "";
        int manches_count = 1;

        // tant que aucun montant de victoire ou de perte vaut le nombre choisis de victoire necessaire
        while (victoire_count.length() < victoires && perte_count.length() < victoires) {
            char resultat = ShiFuMi.uneManche(manches_count);

            // si le joueur 1 gagne
            if (resultat == 'J') {
                victoire_count += resultat;
            }

            // si le joueur 1 perd
            else if (resultat == 'O') {
                perte_count += resultat;
            }

            else if (resultat == 'E') {egalite_count += 'E';}

            // Unexpected case (sans compte "E" car compter les egalites ne nous aident pas)
            else if (resultat != 'E'){
                System.out.println("Unexpected result from ShiFuMi.uneManche() : " + resultat);
            }
            manches_count += 1;

        }
        
        // si le joeur 1 gagne
        if (victoire_count.length() > perte_count.length()) {
            System.out.println("Joueur 1 a gagner ! : " + victoire_count + " / " + perte_count + " / " + egalite_count);
            return (victoire_count + perte_count);
        }

        // si le jouer 1 perd, vu que les pertes du joueur 1 sont les victoires de la machine
        else if (victoire_count.length() < perte_count.length()) {
            System.out.println("Joueur 1 a perdu ! : " + perte_count + " / " + victoire_count + " / " + egalite_count);
            return (victoire_count + perte_count);
        }

        //unexpected case
        else {
            System.out.println("Unexpected edge case : victoire_count =" + victoire_count + ", perte_count =  " + perte_count);
            return (victoire_count + perte_count);
        }

    }


    public static char simulationJeu_Lezard_Spock(String choix_1, String choix_2) {
        if (choix_1.equals(choix_2)) {
            return 'E';
        }
        else if (choix_1.equals("Feuille")) {
            if (choix_2.equals("Pierre") || choix_2.equals("Spock")) {
                return 'J';
            }
            return 'O';
            }
        
        else if (choix_1.equals("Pierre")) {
            if (choix_2.equals("Ciseaux") || choix_2.equals("Lezard")) {
                return 'J';
            }
            return 'O';
        }
        else if (choix_1.equals("Ciseaux")) {
            if (choix_2.equals("Feulle") || choix_2.equals("Lezard")) {
                return 'J';
            }
            return 'O';
        }
        else if (choix_1.equals("Spock")) {
            if (choix_2.equals("Pierre") || choix_2.equals("Ciseaux")) {
                return 'J';
            }
            return 'O';
        }
        else if (choix_1.equals("Lezard")) {
            if (choix_2.equals("Spock") || choix_2.equals("Feuille")) {
                return 'J';
            }
            return 'O';
        }
        else {
            return 'x';
        }
            
        }
    
    public static String tirage_Lezard_Spock (int num) {
    
        // we define a array of strings of size 3 with our options
        String[] choix = {"Pierre", "Feuille", "Ciseaux", "Lézard", "Spock"};

        // unless I missunderstood the domain of the random number, we have to take the modulo
        // of it so it stays in between 0 and 5 <=> num ≡ index [5] s.t. index ∈ {0,1,2,3.4}
        int index = Math.abs(num) % 5;
        return choix[index];

        // to be fair, the principle fo reusability could be ground for debate in this case
        // func tirage could be generalized by passing in arguments the different choices
        // but that would be more cumbersome than efficient, too much code for little use..
    }
    
    public static char uneManche_Lezard_Spock(int num_manche) {

        // on print le numero de la manche ici afin de simplifier la vie pour l'exo 3
        System.out.print("Manche " + num_manche + " ) : ");
        
        String move_Joeur = ShiFuMi.coupJoeur();
        String move_Machine = tirage_Lezard_Spock(ShiFuMi.randRange(69, 420));

        System.out.println();
        System.out.println(); // display purposes

        
        char resultat = simulationJeu_Lezard_Spock(move_Joeur, move_Machine);
        if (resultat == 'J') {
            //System.out.println("Joueur 1 Gagne !");
        }
        else if (resultat == 'O') {
            //System.out.println("Joueur 1 a Perdu !");
        }
        else if (resultat == 'E') {
            //System.out.println("C'est une Egalite !");
        }

        // si resultat vaut 'x', c'est a dire que l'un des arguments de simualtionJeu est innatendu
        else if (resultat == 'x') {
            System.out.println("Move Invalide ! Veuillez re-rentrez votre move : ");
            return uneManche_Lezard_Spock(num_manche);
        }

        // si resultat est une valeur innatendu
        else {
            //System.out.println("Output from simulationJeu is unexpected, here it is  : " + resultat);
        }

        // on retourne sans annoncer le gagnant afin de rendre cette function re-utilisable dans ce sens
        return resultat;
    }

    public static String chifumi_Lezard_Spock (int n) {

        // les variables essentiels (ou pas) a nos calculs
        String resultat_manches = "";
        int j_count = 0;
        int o_count = 0;
        int e_count = 0;

        // on itere n fois pour n manches
        for (int i = 0; i < n; i++) {

            char resultat_une_manche = uneManche_Lezard_Spock(i + 1);

            // Differents cas pour valeurs x = uneManche()
            resultat_manches += resultat_une_manche;
            if (resultat_une_manche == 'J') {
                j_count +=1;
            }
            else if (resultat_une_manche == 'O') {
                o_count += 1;
            }
            else  if (resultat_une_manche == 'E') {
                e_count +=1;
            }
            else {
                System.out.println("Unexpteced output from uneManche : " + resultat_une_manche);
            }
        }

        // Calculs des Scores
        if (j_count > o_count) {
            System.out.println("Joueur 1 a gagner ! : " + resultat_manches);
        }
        else if (j_count == o_count) {
            System.out.println("C'est une egalite ! : " + resultat_manches);
        }
        else if (j_count < o_count) {
            System.out.println("Joueur 1 a perdu ! : " + resultat_manches);
        }
        else {
            System.out.println("Unexpected result : " + resultat_manches);
        }
        return resultat_manches;
    }

    public static void main(String args[]) {
        chifumi_Lezard_Spock(3);
    }
}
