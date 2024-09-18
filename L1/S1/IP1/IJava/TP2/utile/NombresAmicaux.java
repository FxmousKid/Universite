public class NombresAmicaux {

    public static int sumDiv(int n1) {
        int somme = 0;
     
        for (int i = 1; i < n1 ; i++) {
            if (n1 % i == 0) {
                somme += i;
            }
        }
        return somme;
    }

    public static int[] trouveAmicaux(int ceuille) {

        for (int i = 1; i < ceuille; i++) {
            for (int j = 1; j < ceuille; j++) {
                if (sumDiv(i) == j && sumDiv(j) == i) {
                    int[] couple = {i, j};
                    return couple;
                }
            }  
        }  
        return new int[0];
    }



    public static void main(String[] args) {

        System.out.println(trouveAmicaux(1210));

    }
}
