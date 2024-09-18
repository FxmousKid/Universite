public class Cadre {

    public static String line(int n) {
        String res = "--"; //on ajoute deja 2 '-' vu que il ya 2 espaces apres et avant le pipe
        for (int i = 0; i < n; i ++) {
            res += "-"; }
        return res;
    }
    
    public static void frame(String str) {
        

        if (str.contains("\n") == false) {
            String longeur =  line(str.length());

            System.out.println("+" + longeur + "+");
            System.out.println("| " + str + " |");
            System.out.println("+" + longeur + "+");
        }
        
        else {
            char[] str_char = str.toCharArray();
            int newline_count = 0;

            // on compte le nombre de '\n' dans notre string
            for (int i = 0; i < str_char.length; i++) {
                if (str_char[i] == '\n') {
                    newline_count += 1;
               }
            }

            String[] str_no_newline = str.split("\n");
            
            // max_len est la longeur du plus grand string de la phrase qui touche un '\n'
            // on l'utilise comme reference pour les '-'
            int max_len = str_no_newline[0].length();

            for (String example : str_no_newline) {
                if (example.length() > max_len) {
                    max_len = example.length();
                }
            }

            String longeur =  line(max_len);
            System.out.println("+" + longeur + "+");
            

            for (int i = 0; i < newline_count + 1; i++) {

                // space contiendra les espaces pour garder les pipe suppperposer
                String space = "";
                for (int j = 0; j < max_len - str_no_newline[i].length(); j ++) {
                    space += " ";
                }

                System.out.println("| " + str_no_newline[i] + space +" |");
            }

            System.out.println("+" + longeur + "+");

        }
        
    }

    public static void main(String[] args) {
        frame("Ligne 1\nLigne numéro deux\nLigne no 3");

        }


    }

