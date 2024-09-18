public class coupOrdi {

    ShiFuMi object = new ShiFuMi();
    ShiFuMi_bis object_1 = new ShiFuMi_bis();

    public static String coupOrdi_1(String Choix)  {
        /** version de coupOrdi qui renvoie a chaque fois le meme mouvement */
        
        return Choix;

    }

    public static String coupOrdi_2(char sexe, char niveau, int num_manche) {
        /* Suivant cette article : https://www.slate.fr/story/118897/comment-gagner-pierre-feuille-ciseaux
         * j'ai implementer certaines des astuces mentionner afin de pouvoir utilsiser une autre strategie
         * que le randRange(). */

        if (sexe == 'M') {
            if (niveau == 'E') {
                if (num_manche == 1) {
                    return "Ciseaux";
                    // un homme non-expert, jouera Pierre instinctivement au debut, donc un expert jouera le choix 
                    // qui contre ce qui contre la pierre, donc ciseaux
                }
                else {
                    return "Pierre"; 
                }
            }
            else if (num_manche % 3 == 2) {
                return "Pierre"; // choix arbitraire
            }
            else {
                return "Ciseaux";
            }
        }
        else if (sexe == 'F') {
            if (niveau == 'E') {
                if (num_manche == 1) {
                    return "Pierre";
                    // une femme non-experte, jouera Feuille instinctivement au debut, donc une experte jouera le choix 
                    // qui contre ce qui contre la feuille, donc la Pierre
                }
                else {
                    return "Pierre"; 
            }
        }
            else if (num_manche % 3 == 2) {
                return "Pierre"; // choix arbitraire
            }
            else {
                return "Ciseaux";
            }

        }
        return "Pierre";
    }        

    public static char uneManche_coupOrdi_1(int num_manche) {

        // on print le numero de la manche ici afin de simplifier la vie pour l'exo 3
        System.out.print("Manche " + num_manche + " ) : ");
        
        String move_Joeur = ShiFuMi.coupJoeur();
        String move_Machine = coupOrdi_1(ShiFuMi.coupMachine(ShiFuMi.randRange(69, 69)));

        System.out.println();
        System.out.println(); // display purposes

        
        char resultat = ShiFuMi.simulationJeu(move_Joeur, move_Machine);
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
            return uneManche_coupOrdi_1(num_manche);
        }

        // si resultat est une valeur innatendu
        else {
            //System.out.println("Output from simulationJeu is unexpected, here it is  : " + resultat);
        }

        // on retourne sans annoncer le gagnant afin de rendre cette function re-utilisable dans ce sens
        return resultat;
    }
    
    public static String chifumi_CoupOrdi_1(int n) {
        // les variables essentiels (ou pas) a nos calculs
        String resultat_manches = "";
        int j_count = 0;
        int o_count = 0;
        int e_count = 0;

        // on itere n fois pour n manches
        for (int i = 0; i < n; i++) {

            char resultat_une_manche = uneManche_coupOrdi_1(i + 1);

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

    public static char uneManche_coupOrdi_2(int num_manche, char sexe, char niveau) {
        // on print le numero de la manche ici afin de simplifier la vie pour l'exo 3
        System.out.print("Manche " + num_manche + " ) : ");
        
        String move_Joeur = ShiFuMi.coupJoeur();
        String move_Machine = coupOrdi_2(sexe, niveau, num_manche);

        System.out.println();
        System.out.println(); // display purposes

        
        char resultat = ShiFuMi.simulationJeu(move_Joeur, move_Machine);
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
            return uneManche_coupOrdi_2(num_manche, sexe, niveau);
        }

        // si resultat est une valeur innatendu
        else {
            //System.out.println("Output from simulationJeu is unexpected, here it is  : " + resultat);
        }

        // on retourne sans annoncer le gagnant afin de rendre cette function re-utilisable dans ce sens
        return resultat;
    }

    public static String chifumi_coupOrdi_2(int n) {
        // les variables essentiels (ou pas) a nos calculs
        String resultat_manches = "";
        int j_count = 0;
        int o_count = 0;
        int e_count = 0;

        // on demande le niveau et le sex du joueur 1 
        String sexe_J1 = System.console().readLine("Entrez Votre Sexe, Joueur 1, H pour Homme, et F pour Femme : ");
        char[] sexe_J1_arr = sexe_J1.toCharArray();
        char sexe_J1_char = sexe_J1_arr[0];

        String niveau_J1 = System.console().readLine("Entrez vore niveau, Joueur 1, E pour expert, A pour amateur : ");
        char[] niveau_J1_arr = niveau_J1.toCharArray();
        char niveau_J1_char = niveau_J1_arr[0];

        // on itere n fois pour n manches
        for (int i = 0; i < n; i++) {

            char resultat_une_manche = uneManche_coupOrdi_2(i + 1, sexe_J1_char, niveau_J1_char);

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
}







