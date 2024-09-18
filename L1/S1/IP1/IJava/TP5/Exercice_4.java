import java.util.Random;
import java.util.Arrays;


public class Exercice_4 {

    Exercice_2 object = new Exercice_2();

    public static void main(String args[]) {
        int[][] test = createGraph(3);
        print_Arr_Arr(test);
        String[] noms = {"Evan Spiegel", "Mark Zuckerberg", "Jack Dorsey"};
        System.out.println(Arrays.toString(popular_names(test, noms)));

    }

    public static int[][] createGraph(int n) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // we only work with non-diagonal values, because a user cant be friend with themselves
                    res[i][j] = randRange(0, 2);

                    // these 2 ifs make sure that the "friend" relation is equivalent, it goes both way (<=>)
                    if (res[i][j] == 1) {
                        res[j][i] = 1;
                    }
                    if (res[j][i] == 1){
                        res[i][j] = 1;
                    }
                    // my little debug friend :)
                    //System.out.println("res[user="+i+"][friend="+j+"] = " + res[i][j] + ", res[user="+j+"][friend="+i+"] = " + res[j][i]);;
                }
            }
        } 

        return res;
    }

    public static int friends_nbr(int[][] R, int a) {
        int count = 0; 

        for (int i = 0; i < R.length; i++) {
            count += R[a][i]; // si la valeur d'amitie entre user a et user i est 1, donc on l'ajoute
        }
        return count;
    }

    public static int[] friends(int[][] R, int a) {
        int[] status_a = R[a];
        int[] res = new int[0];

        // si user a est ami avec user i, alors R[a][i] == 1 <=> status_a[i] == 1
        for (int i = 0; i < status_a.length; i++) {
            if (status_a[i] == 1) {
                res = append(res, i); // donc on l'ajoute au resultat.
            }
        }

        return res;
    }

    public static int[] popular(int[][] R) {
        int max = 0; 
        // bloc de code pour calculer max; le plus grand nombre d'amis
        for (int[] user : R) {
            int count = 0;
            for (int friends : user) {
                count += friends;
            }
            if (count > max) {
                max = count;
            }
        }

        int[] populaire = new int[0]; // liste des utilisateurs "populaires"

         for (int i = 0; i < R.length; i++) {
            int count = 0; // compteur d'amis qui se re-initialise a 0 a chaque utilisateur
            for (int friends : R[i]) {
                    count += friends; // incremente au nombre d'amis
                }
            if (count == max) { // Si le nombre d'amis de l'utilisateur i est consideré comme "populaire" : 
                // donc on l'ajoute (l'utilisateur i) a la liste d'utilisateur populaires.
                populaire = append(populaire, i);
            }

        }
        return populaire;
    }

    public static int[] common_friends(int[][] R, int a, int b) {
        int[] friends_a = R[a], friends_b = R[b]; // les liste d'amitiès de a et b
        int[] res = new int[0];

        // si la l'index i de friends a et b vaut 1, donc ils sont tout deux ami avec user i
        for (int common_friend = 0; common_friend < R.length; common_friend++) {
            if (friends_a[common_friend] == 1 && friends_b[common_friend] == 1) {
                res = append(res, common_friend); // si il se sont, on l'ajoute au resultat
            }
        }

        return res;

    }

    public static int[][] add_user(int[][] R, int[] t) {
        // on travaille sur une matrice carré, ajoute 1 au nb de colomne, reviens a ajoute 1 au nb de lignes aussi
        int[][] res = new int[R.length+1][R.length+1];
        
        // boucle qui iter sur les utilisateurs
        for (int user = 0; user < R.length; user++) {
            // boucle qui iter sur les valeurs d'amitiés
            for (int friends = 0; friends < R.length; friends++) {
                // sa copie juste les valeurs de R
                res[user][friends] = R[user][friends];
            }
            // cette ligne s'occupe de mettre la bonne valeur d'amitie entre user "user" et user t
            res[user][R.length] = t[user];
        }
        // cette ligne ajoute uniquement le user t a notre reseau.
        res[R.length] = t;
        return res;
        
    }

    public static String[] popular_names(int[][] R, String[] noms) {
        int[] populaires = popular(R); 
        String[] res = new String[populaires.length];


        for (int i = 0; i < res.length; i++) {
            // populaires[i] nous donnes les utilisateurs les plus populaires du reseau, noms[populaires[i]] donne leur noms, easy :)
            res[i] = noms[populaires[i]];
        }
        return res;
        

    }

    static Random rand = new Random();
    public static int randRange(int a, int b) {
        return (rand.nextInt(b-a) + a);
    }

    public static void print_Arr_Arr(int[][] tab) {
        System.out.print("arr = {");
        for (int i =0; i < tab.length; i++) {
            
            System.out.print("{");
            for (int j = 0; j < tab[i].length - 1; j++) {
                System.out.print(tab[i][j] + ", ");
            }
            System.out.print(tab[i][tab[i].length-1]);
            System.out.print("}, ");

        }
        System.out.println("}");
    }

    public static int[] append(int[] tab, int a) {
        int[] res = new int[tab.length+1] ;

        for (int i = 0; i < tab.length; i++) {
            res[i] = tab[i];
        }

        res[tab.length] = a;
        return res;
    }
}