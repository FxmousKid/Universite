import java.util.Random;
public class RandomArray {
 static Random rand = new Random();
 Exercice_1 object = new Exercice_1();

/* ************************************************************************** */
  

    //  QUESTION 1 
    public static int[] createRandomArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }

        return arr;
    }


    // QUESTION 2
    public static int[] minMaxAverage(int[] a) {
        int[] min_max = {a[0], a[1], 0};

        for (int i = 0; i < a.length; i++) {
            
            if (a[i] < min_max[0]) {
                min_max[0] = a[i];
                
            }
            if (a[i] > min_max[1]) {
                min_max[1] = a[i];
            }

            min_max[2] += a[i];
        }

        min_max[2] /= a.length;
        return min_max;

        
    }


    // QUESTION 3
    public static int[] occurrences(int[] a) {
        int len_res = minMaxAverage(a)[1] + 1;
        int[] res = new int[len_res];

        // 0-ing every element in res
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }


        for (int entier = 0; entier < res.length; entier++) {
            for (int parcour_a = 0; parcour_a < a.length; parcour_a++) {
                if (a[parcour_a] == entier) {
                    res[entier] += 1;
                }
            }
        }
        
        return res;
    }

    // QUESTION 4a
    public static int[] countingSort(int[] a) {
        int[] occ_a = occurrences(a);
        int[] res = new int[0];
        

        for (int i = 0; i < occ_a.length; i++) {
            for (int j = 0; j < occ_a[i]; j++) {
                res = Exercice_1.append(res, i);
            }
        }

        return res;
    }

    // QUESTION 4b
    public static void countingSort2(int[] a) {

        int[] res = new int[0];
        int[] count = countingSort(a);

        for (int elem : count) {
            if (Exercice_1.search(res, elem) == false) {
                res = Exercice_1.append(res, elem);
            }
        }
        printIntArray(res);;
    }


    /******************************************/
    /*     Fonctions auxiliaires              */
    /******************************************/

    public static boolean  intArrayEquals (int[] a, int[] b){
    if (a.length!=b.length) {
        return false;
    }
    for (int i=0; i<a.length; i++){
        if (a[i]!=b[i]){
            return false;
        }
    }
    return true;
    }

    public static void printIntArray (int[] a){
    for (int i = 0; i<a.length ; i++){
        System.out.print(a[i] + " ");
    }
    System.out.println();
    }

    /* ********************************************************** */
    /*      Fonction Principale                                   */
    /* ********************************************************** */


    public static void main(String[] args){
    //System.out.println("Entrez un entier positif (la taille du tableau):");
    //int n = Integer.parseInt(System.console().readLine());
    //int[] a = createRandomArray(n);	
    
    int[] a = {1,3,0,0,0,1};
    printIntArray(occurrences(a));
    countingSort2(a);

    }


}