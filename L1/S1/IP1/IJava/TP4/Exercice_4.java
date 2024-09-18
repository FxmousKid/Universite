public class Exercice_4 {
    
    Exercice_1 object = new Exercice_1();

    public static void main(String args[]) {
        
    }

    public static void letters2word(char[] arr) {
        String res = "";
        for (char elem : arr) {
            res += elem;
        }
        System.out.println(res);
    }

    public static void stutterword(char[] tab1, int[] tab2) {
        if (tab1.length != tab2.length) {
            System.out.println("Erreur");
        }

        String res = "";
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab2[i]; j++) {
                res += tab1[i];
            }
        }

        System.out.println(res);
    } 

    public static char[] word2letters(String mot) {
        char[] res = new char[mot.length()];

        for (int i = 0; i < mot.length(); i++) {
            res[i] = mot.charAt(i);                
            }
        
        return res;

    }

    public static char[] letters(String mot) {
        char[] res = new char[mot.length()];

        for (int i = 0; i < mot.length(); i++) {
            if (search(res, mot.charAt(i)) == false) {
                res[i] = mot.charAt(i);             
            }   
        }

        return res;
    }
    
    public static boolean search(char[] arr, char x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }
}
