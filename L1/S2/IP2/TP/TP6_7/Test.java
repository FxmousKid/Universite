public class Test {

    public static void main(String[] args) {
       
        int n = 7;
        // Test du Constructeur d'automate + de l'affichage
        System.out.println("Test de l'automate apres " + n + " mise a jour, regle UNANIMITE");
        Automate a1 = new Automate("---------#--------");
        a1.Affichage();
        System.out.println();
        a1.nEtapeUnanimite(n);
        System.out.println("\n\n");

        System.out.println("Test de l'Automate apres " + n + " mise a jour, regle MAJORITE");
        Automate a2 = new Automate("#-#-#-#-#-#-#-#-#-#");
        a2.Affichage();
        System.out.println();
        a2.nEtapeMajorite(n);
        System.out.println();

    
    }
}
