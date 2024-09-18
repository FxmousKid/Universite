import java.util.Random;
import java.lang.Math;


public class ShiFuMi {

    static Random rand = new Random();
    public static int randRange(int a, int b) {
        return (rand.nextInt(b-a) + a);
    }

    public static String coupMachine (int num) {
        
        // we define a array of strings of size 3 with our options
        String[] choix = {"Pierre", "Feuille", "Ciseaux"};

        // unless I missunderstood the domain of the random number, we have to take the modulo
        // of it so it stays in between 0, 1, and 2 <=> num ≡ index [3] s.t. index ∈ {0,1,2}
        int index = Math.abs(num) % 3;
        return choix[index];
    }

    public static String coupJoeur() {
        
        // Asks user for his move
        String choix_J1 = System.console().readLine("Joeur 1, Entrez Votre choix : ");
    
        return choix_J1;
    }

    public static char simulationJeu(String choix_1, String choix_2) {
        
        // Case 0 : Both side pick the same thing
        if (choix_1.equals(choix_2)) {
            return 'E';
        }
        
        // Case 1 : Player chooses Rock
        if (choix_1.equals("Pierre")) {
            if (choix_2.equals("Ciseaux")) {
                return 'J';
            }
            return 'O';
        }
        // Case 2 : Player chooses Paper
        else if (choix_1.equals("Feuille")) {
            if (choix_1.equals("Pierre")) {
                return 'J';
            }
            return 'O';
        }
        // Case 3 : Player chooses Cisors
        else if (choix_1.equals("Ciseaux")) {
            if (choix_2.equals("Ciseaux")) {
                return 'J';
            }
            return 'O';
        }
        // return this in case inputs is not sanitised <=> Input /∈ ["Feuille", "Ciseaux", "Pierre"]
        return 'x';    

        
    }
        
    public static char uneManche(int num_manche) {

        // on print le numero de la manche ici afin de simplifier la vie pour l'exo 3
        System.out.print("Manche " + num_manche + " ) : ");
        
        String move_Joeur = coupJoeur();
        String move_Machine = coupMachine(randRange(69, 420));

        System.out.println();
        System.out.println(); // display purposes

        
        char resultat = simulationJeu(move_Joeur, move_Machine);
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
            return uneManche(num_manche);
        }

        // si resultat est une valeur innatendu
        else {
            //System.out.println("Output from simulationJeu is unexpected, here it is  : " + resultat);
        }

        // on retourne sans annoncer le gagnant afin de rendre cette function re-utilisable dans ce sens
        return resultat;
    }

    public static String chifumi (int n) {

        // les variables essentiels (ou pas) a nos calculs
        String resultat_manches = "";
        int j_count = 0;
        int o_count = 0;
        int e_count = 0;

        // on itere n fois pour n manches
        for (int i = 0; i < n; i++) {

            char resultat_une_manche = uneManche(i + 1);

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

    public static void main (String args[]) {
        chifumi(5);
    }



}