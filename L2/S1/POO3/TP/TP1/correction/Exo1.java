public class Exo1{
    
    public static void main(String[] args){
        /* 1. De type void */
        
        /* 2. */
        System.out.println("Nombre d'arguments : " + args.length);
        
        /* 3. La méthode length(): Par exemple: */
         String s = "java";
         System.out.println(s.length());
        
        /* Dans la classe Math.
            La fonction Math.hypot() renvoie la racine carrée de la somme des carrés de ses deux  arguments. Les arguments doivent être de type double.
            Math.hypot(x, y) = sqrt(x^2 + y^2). Par exemple */
         System.out.println(Math.hypot(2.0, 3.0));
    }
}
