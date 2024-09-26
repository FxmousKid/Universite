public class Exo2{
    
    /* 1 */
    public static void affiche(int[] t){
        for(int i : t){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    /* 2 */
    public static int[] multiplication(int[] t1, int[] t2){
    
        int max = Math.max(t1.length, t2.length);
        
        int[] result = new int[max];
        
        for(int i = 0; i<max; i++){
            
            int a1 = (i < t1.length) ? t1[i] : 1;
            int a2 = (i < t2.length) ? t2[i] : 1;
                
            result[i] = a1 * a2;
        }
        
        return result;
    }
    
    /* 4 */
    public static int[] split(int[] t){
        
        int n = t.length;
        String[] tString = new String[n];
        
        /* Calculer la taille du nouveau tableau en comptant le nombre de caractères*/
        int l = 0;
        for(int i = 0; i<n; i++){
            tString[i] = String.valueOf(t[i]);
            l += tString[i].length();
        }
        
        System.out.println("length = "+l);
        
        int[] result = new int[l];
        
        int index = 0;
        for(String s : tString){
            for(int i = 0; i<s.length(); i++){
                result[index] = Character.getNumericValue(s.charAt(i));
                index ++;
            }
        }
            
        
        return result;
    }
    
    public static void main(String[] args){
        
        int t1[] = {1,3,5,7};
        int t2[] = {2,4,6};
        
        /* 1 */
        affiche(t1);
        affiche(t2);
        
        /* 2 */
        int t3[] = multiplication(t1,t2);
        affiche(t3);
        
        /* 4 */
        int t4[] = split(t3);
        affiche(t4);
    }
}
