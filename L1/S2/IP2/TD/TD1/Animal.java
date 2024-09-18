
public class Animal {
    String nom;
    String espece;
    int age; // en jours
    int poids; // en KGs
    char sexe; //  ‘m’ pour un mâle, ‘f’ pour une femelle ;

    Animal (String nom, char sexe, int poids, int age, String espece) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.age = age;
        this.espece = espece;
    }

    public static String description(Animal animal_arg) {
        String sexe_complet = (animal_arg.sexe == 'm') ? "Male" : "Femelle";
        String rendue = "Je m'appelle " + animal_arg.nom + ", je suis un " + animal_arg.espece + " " + sexe_complet + ", j'ai " + animal_arg.age + " jours et je pese " + animal_arg.poids + " kg";
        return rendue;
    }

    public static void main(String[] args) {
        Animal marti = new Animal("Marti", 'm', 300, 1825, "zebre");
        Animal gloria = new Animal("Gloria", 'f', 1500, 2555, "hippopotame");

        int[] test = new int[3];
        System.out.println(test.length);

        gloria.poids -= 50;
        System.out.println(Animal.description(gloria));
    }

}
