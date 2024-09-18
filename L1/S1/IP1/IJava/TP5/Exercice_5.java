import java.util.Arrays;

public class Exercice_5 {

    Exercice_2 object_1 = new Exercice_2();
    Exercice_4 object_2 = new Exercice_4();

    public static void main(String args[]) {
        int[][] test = Exercice_4.createGraph(3);
        String[] noms = {"Evan Spiegel", "Mark Zuckerberg", "Jack Dorsey"};
        Exercice_4.print_Arr_Arr(test);
        System.out.println(Arrays.toString((invite_names(test, 0, noms))));

    }

    public static int[] invite(int[][] R, int a) {
        int[] res = new int[0], status_a = R[a];

        // on itere tout d'abord dans les valeur d'amities de user a
        for (int amis_a = 0; amis_a < status_a.length; amis_a++) {
            // si user a et user amis_a sont amis, et amis_a n'est pas user a :
            if (status_a[amis_a] == 1 && amis_a != a) {
                // deja, on ajoute user amis_a
                res = Exercice_4.append(res, amis_a);
                // et on prend la liste des valeurs d'amitiés de user amis_a
                int[] status_amis_a = R[amis_a];

                // meme procede que a la ligne 19, mais avec les amis de user amis_a
                for (int amis_amis_a = 0; amis_amis_a < status_amis_a.length; amis_amis_a++) {
                    // pareille que ligne 21, si user amis_a est amie avec user amis_amis_a, et 
                    // user amis_amis_a n'est pas a, on l'ajoute a la liste des invites.
                    if (status_amis_a[amis_amis_a] == 1 && amis_amis_a != a) {
                        res = Exercice_4.append(res, amis_amis_a); // on l'ajoute ici.
                    }
                }
            }
        }

        return res;
    }

    public static int[] strict_invite(int[][] R, int a) {
        int[][] P = new int[R.length][R.length];
        int[] res = new int[0];

        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R.length; j++) {
                int somme = 0;
                for (int k = 0; k < R.length; k++) {
                    somme += R[i][k] * R[k][j];
                }
                P[i][j] = somme;
            }
        }
        
        for (int i = 0; i < P.length; i++) {
            if (P[i][a] == 2) {
                res = Exercice_4.append(res, i);
            }
        }

        return res;
    }

    public static String[] invite_names(int[][] R, int a, String[] noms) {
        int[] invites = invite(R, a);
        String[] res = new String[invites.length];

        for (int i = 0; i < invites.length; i++) {
            res[i] = noms[invites[i]];
        }

        return res;
    }

    public static String[] strict_invite_names(int[][] R, int a, String[] noms) {
        int[] strict_invites = strict_invite(R, a);
        String[] res = new String[strict_invites.length];

        for (int i = 0; i < strict_invites.length; i++) {
            res[i] = noms[strict_invites[i]];
        }

        return res;


    }

}
