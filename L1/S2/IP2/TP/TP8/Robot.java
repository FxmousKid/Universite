import java.lang.Math;

public class Robot {

	private	final String	texte; // dialog to say
	private	final char		nom;     // nom in [az]
	static	int				nbRob = 0;
	private	int				energie;        // Energie of robot
	private	int				id;
	private	int				np;

	Robot (char nom, String texte) {
		this.nom   = nom;
		this.energie = 10  + (int) (Math.random() * 11);
		this.texte = texte;	
		nbRob++; 
		this.id = nbRob;
		this.np = letterCount(this.texte);				
	}


	public int getId() {
		return this.id;
	}

	public char getNom() {
		return this.nom;
	}

	public int getNp() {
		return this.np;
	}

	public int letterCount(String text) {
		int rendue;

		rendue = 0;
		for (int i = 0; i < text.length(); i++) {
			rendue++;
		}
		return rendue;
	}

	public boolean finiDeParler() {
		return this.np == 0;
	}

	public int parler(int n) {
		
		// Error control flow
		if (n > np) {
			System.out.println("n > np, cant speak this much ! ; exiting");
			System.exit(1);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(this.texte.charAt(i));
		}
		System.out.println(); // A simple newline after speaking.
		this.np -= n;
		return (this.np);		
	}

	public String description() {
		return "Robot" + nom + " dit " + texte +
				" quand il parle et a " + energie +
				" points d'energie";
	}
}
