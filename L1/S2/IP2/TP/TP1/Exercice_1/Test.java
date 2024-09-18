class Test {
    
    public static void main(String[] args) {
        Fruit f = new Fruit("pamplemousse", 330);
        Fruit g = new Fruit("pamplemousse", 330);
        Fruit h = f; 

        Fruit a = new Fruit("apple", 123);
        Fruit b = new Fruit("pear", 131);
        Fruit c = new Fruit("kiwi", 1311);

        //Ex 1.2 : On peut dire que f, g, et h sont des references a des objects, et donc imprimer
        // un des objects directement resultera en une adresse memoire

        // Ex 1.3 : Bahh j'avais prevu la meme chose.. h est juste une autre reference a l'object auquelle
        //  f pointe

        // Ex 1.4 : C'est bon tout fonctionne grace a public et le faite que le constructeur Fruit est publique
    
        Fruit.afficher(f); // Ex 1.5 : Sa fonctionne !
        Fruit res_hybrid = Fruit.hybridation(f, g);
        Fruit.afficher(res_hybrid);


        // Test pour la class Panier

        Panier p1 = new Panier(a, new Panier());
        p1 = new Panier(b, p1);
        p1 = new Panier(c, p1);
        p1 = new Panier(f, p1);

        Panier.afficher(Panier.hybridePanier(g, p1));
    
    }
}