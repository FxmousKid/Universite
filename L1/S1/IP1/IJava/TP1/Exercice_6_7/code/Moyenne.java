public class Moyenne {


    
    public static int Moyenne_arithmetique(int n1, int n2, int n3, int n4, int n5) {   
        
        int sum_n = n1 + n2 + n3 + n4 + n5;
        return sum_n / 5;

    }
    public static void main(String[] args) {
        System.out.println(Moyenne_arithmetique(1,1,1,1,1));
        System.out.println(Moyenne_arithmetique(1,5,3,2,1));
        
    };

}
