 public class Exercice_1 {

    public static void main(String args[]) {
        //int[] tab={6,20,12,1000,8};
        //System.out.println(search(tab, 1));

        int[] tab1={6,7};
        int[] tab2={3,1,4,5};
        
        //afficher(union(tab1, tab2));
        System.out.println(4 % 400);

    }

    public static boolean search(int[] arr, int x) {
        // verify x's membership in arr -> bool

        for (int elem : arr) {
            if (elem == x) {
                return true;
            }
        } 
        return false;
    }

    public static int[] union(int[] arr1, int[] arr2) {
        int[] unionized = new int[1];
        
        for (int elem_1 : arr1) {
            if (search(unionized, elem_1) == false) {
                unionized = append(unionized, elem_1);
            } 
        }
        
        for (int elem_2 : arr2) {
            if (search(unionized, elem_2) == false) {
                unionized = append(unionized, elem_2);
            }
        }
        return unionized;
    }

    public static int[] append(int[] arr, int x) {
        int[] mod_arr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            mod_arr[i] = arr[i];
        }
        mod_arr[arr.length] = x;
        return mod_arr;
    }

    public static <T> void afficher(T[] arr) {
        System.out.print("the array is : [");
        for (T elem : arr ) {
            System.out.print(elem + ",");
        }
        System.out.println("]");
    }
}