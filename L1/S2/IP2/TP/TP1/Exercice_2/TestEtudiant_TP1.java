public class TestEtudiant_TP1 {
    
    public static void main(String[] args) {
        Etudiant_TP1 e1 = new Etudiant_TP1("Luke", "Skywalker", 1, 11);
        Etudiant_TP1 e2 = new Etudiant_TP1("Leia", "Organa", 0, 16);


        System.out.println("\nQuestion 3 : ");
        Etudiant_TP1.afficher(e1);

        System.out.println("\nQuestion 4 : ");
        System.out.println("e1 est admis : " + Etudiant_TP1.estAdmis(e2));

        System.out.println("\nQuestion 5: ");
        System.out.println("la metion de e1 est : " + Etudiant_TP1.mention(e1));
        System.out.println("la metion de e2 est : " + Etudiant_TP1.mention(e2));

    }
}
