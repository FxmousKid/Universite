public class Exercice_2 {

    public static void main(String args[]) {
        int[][] test = {{2, 3}, {5, 8, 13, 21}, {34}};
        print_arr(rowSums(test));
    }

    public static int[] rowSums(int[][] tab) {
        int[] res = new int[tab.length];

        for (int sous_tab = 0; sous_tab < tab.length; sous_tab++) {
            for (int elem : tab[sous_tab]) {
                res[sous_tab] += elem;
            }
        }

        return res;
    }

    public static void print_arr(int[] arr) {
        System.out.print("array is : [");
        for (int i = 0; i < arr.length -1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println("]");
    }

}