import java.util.Date;

public class Test {
    
    
    public static void main(String[] args) {
        
        Utilisateur u1 = new Utilisateur("joex12", "joe123", "joe@gmail.com");
        //Exercice 1 Question 3 :
        System.out.println("\nExercice 1 Question 3 : ");
        System.out.println("test mot de pass : "  + u1.testMotDePasse("joe123"));
        System.out.println("\nExercice 1 Question 3.1 : ");
        System.out.println("Cahgnement de mot passe en joe12345");
        u1.changerMotDePasse("joe1234", "joe12345");
        System.out.println("test de mot de passe : " + u1.testMotDePasse("joe12345"));
        
        //Exercice 1 Question 4 :
        System.out.println("\nQuestion 4 : ");
        System.out.println("Pseudo de u1 : " + u1.getPseudonyme());
        System.out.println("Changement de Pseudo de joex12 a joex13");
        u1.setPseudonyme("joe12345", "joex13");
        System.out.println("nouveau Pseudo de u1 : " + u1.getPseudonyme());
    
        // Exercice 2
        System.out.println("\nExercice 2 : ");
        System.out.print("Test de la fonctionalite d'envoi de message");
        Utilisateur u2 = new Utilisateur("jean12", "jean123", "jean12@gmail.com");
        Date d1 = new Date();
        Message m1 = new Message(u1, d1.getTime(), "Coucou c'est joe !");
        m1.Send_display();

        // Exercice 3
        System.out.println("\nExercice 3 : ");
        System.out.println("Test de la fonction afficher : \n");
        Date d2 = new Date();
        Message m2 = new Message(u2, d2.getTime(), "Couccou ! je m'apple Jean");
        Date d3 = new Date();
        Message m3 = new Message(u1, d3.getTime(), "Salut Jean ! moi c'est joe !");            
        Salon s1 = new Salon(10, 10);
        s1.append_user(u1);
        s1.append_user(u2);
        s1.append_message(m1);
        s1.append_message(m2);
        s1.append_message(m3);
        s1.afficher();

        // Proposition d'implementation de l'exericce 7 :
        // on creer une fonction "public void rm_user(Utilisateur s1)" dans la classe Salon.
        // next, on fais 2x parcour, un dans tabutilisateur, où l'on garde les users qui ne sont
        // pas celui que l'on veut enlever, et un autre dans tabMessage, où l'on traverse le log 
        // des messages, et où l'on garde uniquement les messages non-envoyer par le user en question
        // Pour conclure, voila une approche que j'aurais utiliser afin de faire ce qui est demander.
    
    }

}
