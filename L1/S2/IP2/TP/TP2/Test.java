import java.text.DecimalFormat;

public class Test {
    
    // Ex 1.2 : static fait transforme un attribut d'instance en un attribut de variable, et final
    // rend une variable non-modifiable apres qu'elle a etait initializer.

    // Ex 1.4 Perso j'aimerais pas avoir un nb d'etudiants negatifs, mais apres si faut bel et bien 
    // tout tester, et donc bien sur qu'il faut essayer de rendre nombreDEtudiants negatifs 
    // afin d'observer son effet plus large sur le code en entier (bien sure dans ce cas c'est simple
    // note code en long et en large et aussi grand qu'une issue sur le git de la kernel de Linux...)

    public static void main(String[] args) {

        // EXERCICE 1 ! EXERCICE 1 ! EXERCICE 1 ! EXERCICE 1 ! EXERCICE 1 ! 

        Etudiant e1 = new Etudiant("Luke", "Skywalker", 8.25);
        Etudiant e2 = new Etudiant("Leia", "Organa", 11.75);
        System.out.println("\nExercice 1 Question 4 :");
        System.out.println("nb d’etudiants: " + Etudiant.nombreDEtudiants );
        System.out.println("somme des notes: " + Etudiant.sommeDesNotes );

        System.out.println("\nExercice 1 Question 5 :");
        // un petit 20 mignonn par ci par laa~~
        Etudiant iyan = new Etudiant("iyan", "nazarian", 20.0); 
        System.out.println("nb d’etudiants: " + Etudiant.nombreDEtudiants );
        
        System.out.println("\nExercice 1 Question 7 :");
        e1.afficher();
        e2.afficher();
        Etudiant.afficher2(iyan);

        System.out.println("\nExercice 1 Question 8 :");
        System.out.println("Iyan est admis : " + iyan.estAdmis());
        System.out.println("(C'est evident... )");

        System.out.println("\nExercice 1 Question 9 :");
        // c'est juste pour limiter le nombre de chiffres apres la virgule..
        DecimalFormat moyenne_format = new DecimalFormat("#.00");
        double etu_moyenne = Etudiant.moyenne();
        System.out.println("La moyenne  de tout les eleves est : " + moyenne_format.format(etu_moyenne));

        System.out.println("\nExercice 1 Question 10 :");
        System.out.println("iyan est meuilleur que la moyenne ? : " + iyan.meuilleurQueLaMoyenne());
        // (alllerrrrr)

        System.out.println("\nExercice 1 Question 11 :");
        e2.modifierNote(19.5);
        e2.afficher();
        // va falloir faire passer mon 20 a un 14.25 😔😔😔
        iyan.modifierNote(14.25);
        System.out.println("moyenne : "+Etudiant.moyenne());
        // bel est bien 14 !


        // EXERCICE 2 ! EXERCICE 2 ! EXERCICE 2 ! EXERCICE 2 ! EXERCICE 2 ! EXERCICE 2 ! 

        // Exercice 2 Question 3
        Trio trio_1 = new Trio(iyan, e1, e2);
        
        System.out.println("\nExercice 2 Question 4 :");
        System.out.println("L'eleve premier du trio est : " + trio_1.premier().prenom);

        System.out.println("\nExercice 2 Question 5 :");
        int rang_luke = trio_1.classement("Luke", "Skywalker");
        System.out.println("le rang de Luke dans notre trio est : " + rang_luke);

        System.out.println("\nExercice 2 Question 6 :");
        System.out.println("La moyenne de notre trio est de : " + trio_1.moyene());
        // on va ajouter un eleve car le trio litteralemetn contient la promo hahahaha
        Etudiant e3 = new Etudiant("Jean", "Valjean", 13);
        //Verifions la moyenne de la promo :
        System.out.println("La moyenne de la promo est : " + Etudiant.moyenne());
        System.out.println("Est ce que la note du trio > la note de la promo : " + trio_1.meuilleurQueLaMoyenne());






        

    }
}
