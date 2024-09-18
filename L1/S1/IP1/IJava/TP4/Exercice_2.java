import java.lang.Math;

public class Exercice_2 {
    
    Exercice_1 object = new Exercice_1();
    
    public static void main(String args[]) {
        Integer[] arr = {1,2,3,4,5};
        Exercice_1.afficher(shift(arr, -2));

    }

    public static Integer[] shift(Integer[] arr, int n) {
        Integer[] new_arr = new Integer[arr.length];

        if (n % arr.length == 0) {
            return arr;
        }

        if (n < 0 ) {
            n = (Math.abs(n) % arr.length); // makes n in [1; arr.length - 1]
            //System.out.println(n);

            // 1st loop for the new first integers 
            for (int i = 0; i < arr.length - n; i++) {
                new_arr[i] = arr[i+n];
            }
            
            // 2nd loop for last n-integers 
            for (int i = arr.length - n; i < arr.length; i++) {
                new_arr[i] = arr[i - arr.length + n];
            }
        }

        if (n > 0) {
            n = (Math.abs(n) % arr.length); // makes n in [1; arr.length - 1]
            //System.out.println(n);

            // 1st loop for the new first integers 
            for (int i = 0; i < n ; i++  ) {
                new_arr[i] = arr[i+n+1];
            }
            
            // 2nd loop for last n-integers 
            for (int i = n; i < arr.length; i++) {
                new_arr[i] = arr[i-n];
            }
        }

        return new_arr;
        

    }

    public static int[] append(int[] arr, int x) {
        int[] mod_arr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            mod_arr[i] = arr[i];
        }
        mod_arr[arr.length] = x;
        return mod_arr;
    }



}
