public class Combat{
    
    public static void main(String[] args) {
        
        Personnage p1 = new Personnage("Alice",14,2,8);
        Personnage p2 = new Personnage("Bob",8,7,2);
        
        Personnage.lutteIte(p1,p2);
        
        System.out.println();

        p1 = new Personnage("Bob",8,7,2);
        p2 = new Personnage("Alice",14,2,8);
        
        Personnage.lutteRec(p1, p2);
        
    }

}
