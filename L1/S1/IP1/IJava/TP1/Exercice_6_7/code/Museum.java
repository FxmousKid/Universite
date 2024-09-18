public class Museum {
	/* EXERCICE 15 */
	public static int reduction(int birthyear, int year) {
		int age = year - birthyear;
		int deduction = 0;
		if (age < 18) {
			deduction =  5;
		}
		else if (age >= 60) {
			deduction = 3;
		};

		return deduction;
	}

	/* EXERCICE 16*/
	public static int price (int birthyear,int year,int price) {

		int montant_reduire = reduction(birthyear, year);
		int prix_total = price - montant_reduire;

		if  ( prix_total > 0) {
			return prix_total;
		}
		else {
			return 0;
		}
	}
	
	/*************************************************************/
	/* PROGRAMME PRINCIPAL*/
	
	public static void main (String[] args) {
	
	
		System.out.println("====Exo 15====");
		testInt("reduction(2004,2021)", reduction(2004,2021), 5);
		testInt("reduction(1958,2021)", reduction(1958,2021), 3);
		testInt("reduction(2003,2021)", reduction(2003,2021), 0);
		testInt("reduction(1940,2000)", reduction(1940,2000), 3);
		testInt("reduction(1979,2000)", reduction(1979,2000), 0);
		
		System.out.println("====Exo 16====");
		testInt("price(2005,2021,25)",price(2005,2021,25),20);
		testInt("price(1958,2021,2)", price(1958,2021,2),0);
		testInt("price(1992,2021,10)",price(1992,2021,10),10);
		
	}
	
	/*************************************************************/
	/* NE PAS MODIFIER */
	/*************************************************************/
	public static void testInt(String cmd, int exp, int val) {
		System.out.println(cmd + " == " + exp);
		if (exp != val) {
            System.out.println("Ce n'est pas la bonne réponse!");
		}
	}
    /*************************************************************/ 

	
}
