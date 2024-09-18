public class Exercice_6 {
    Exercice_1 object = new Exercice_1();
    RandomArray object_2 = new RandomArray();

    public static void main(String args[]) {
        int[] tab ={4,6,3,5};
        RandomArray.printIntArray(sort(tab));

    }

    public static int position(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x < arr[i]) {
                return i;
            }
        }
        return arr.length-1;
    }

    public static int[] insert(int[] arr, int pos, int x) {
        if (pos >= arr.length) {
            return arr;
        }

        int[] new_arr = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (i == pos) {
                new_arr = Exercice_1.append(new_arr, x);
                new_arr = Exercice_1.append(new_arr, arr[i]);
            }
            else {
                new_arr = Exercice_1.append(new_arr, arr[i]);
            }
        }
        return new_arr;
    }

    public static int[] sort(int[] a) {

        int[] res = new int[2];
        res[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            int pos = position(res, a[i]);
            System.out.print("a[i] = " + a[i] + ", miropos = " + pos + ", res = ");
            RandomArray.printIntArray(res);
            res = insert(res, pos, a[i]);
        }
    
        int[] new_arr = new int[0];
        for (int i = 0; i < res.length -1; i++) {
            new_arr = Exercice_1.append(new_arr, res[i]);
        }
        
        return new_arr;
    }

}
