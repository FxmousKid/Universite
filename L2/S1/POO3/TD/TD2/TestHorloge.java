public class TestHorloge {
    private static void testCompteurCyclique() {
        CompteurCyclique compteur = new CompteurCyclique(1000);
        for (int i = 0; i < 5000; i++) {
            System.out.println(compteur.toString());
	    compteur.incrementer();
        }
    }

    private static void testHorloge() {
        Horloge horloge = new Horloge(23, 55);
        for (int i = 0; i < 100; i++) {
            horloge.incrementer();
            System.out.println(horloge.toString());
        }
    }
    public static void main(String[] args) {
        // testCompteurCyclique();
        testHorloge();
    }
}
