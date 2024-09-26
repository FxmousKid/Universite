/* Exercice 3*/

public class Shift{
    
    /* Methode qui prend en entrée un charactère et si c'est une voyelle
     le remplace par la voyelle qui la précéde dans l'alphabet.*/
    
    public static char shift(char c) {
        
        if(c == 'a') return 'y';
        else if(c == 'e') return 'a';
        else if(c == 'i') return 'e';
        else if(c == 'o') return 'i';
        else if(c == 'u') return 'o';
        else if(c == 'y') return 'u';
        else if(c == 'A') return 'Y';
        else if(c == 'E') return 'a';
        else if(c == 'I') return 'E';
        else if(c == 'O') return 'I';
        else if(c == 'U') return 'O';
        else if(c == 'Y') return 'U';
        else return c;
    }
    
    /* Methode qui prend en entrée une chaîne de caractères et qui renvoie la
     chaîne de caractères shiftée.*/
    
    public static String shift(String s){
        String result = "";
        for(int i = 0; i<s.length(); i++){
            result += shift(s.charAt(i));
        }
        return result;
    }
    
    
    
    
    public static void main(String[] args){
        for(int i = 0; i<args.length; i++){
            System.out.print(shift(args[i])+" ");
        }
        System.out.println();
    }
}
