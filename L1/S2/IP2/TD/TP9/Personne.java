public class Personne {
	
	private final String prenom, nomDeFamille;
	private Personne mere, pere;

	public Personne (String prenom, String nomDeFamille) {
		this.prenom = prenom;
		this.nomDeFamille = nomDeFamille;
	}

	public Personne (String prenom, String nomDeFamille, Personne pere, Personne mere) {
		this.prenom = prenom;
		this.nomDeFamille = nomDeFamille;
		this.pere = pere;
		this.mere = mere;
	}

	public boolean estFrereOuSoeur(Personne p) {
		if (p == null)
			return (false);
		if (this.mere == null && this.pere == null)
			return (false);
		return (this.mere.equals(p.mere) && this.pere.equals(p.pere));
	}

	public boolean estCousinGermain(Personne p) {
		if (p == null)
			return (false);
		return (this.pere.estFrereOuSoeur(p.pere) || this.pere.estFrereOuSoeur(p.mere) || this.mere.estFrereOuSoeur(p.pere) || this.mere.estFrereOuSoeur(p.mere));
	}

	public int nbAscendants() {
		if (this.mere == null && this.pere == null) 
			return (0);
	
		int hasPere = (this.pere != null) ? 1 : 0;
		int hasMere = (this.mere != null) ? 1 : 0;
		if (hasPere == 0) {
			return (hasMere + hasPere + this.mere.nbAscendants());
		}
		else if (hasMere == 0) {
			return (hasMere + hasPere + this.pere.nbAscendants());
		}
		else {
			return (hasMere + hasPere + this.mere.nbAscendants() + this.pere.nbAscendants());
		}
	}

	public boolean possedeCommeAscendant(Personne p) {
		if (p == null)
			return (false);

		if (this == p)
			return (true);
		
		if (this.pere == null && this.mere == null)
			return (false);
		
		if (this.pere == null)
			return (this.mere.possedeCommeAscendant(p));

		else if (this.mere == null)
			return (this.pere.possedeCommeAscendant(p));
		
		else {
			return (this.pere.possedeCommeAscendant(p) || this.mere.possedeCommeAscendant(p));
		}	
	}

	public int distanceDAscendance_aux(Personne p) {
		if (p == null)
			return (-1);

		if (!this.possedeCommeAscendant(p))
			return (-1);

		if (this == p)
			return (0);

		if (pere == null && mere == null)
			return (-1);

		if (this.pere == null) {
			if (this.mere.possedeCommeAscendant(p)) {
				return (1 + this.mere.distanceDAscendance_aux(p));
			}
			return (0);
		}

		if (this.mere == null) {
			if (this.pere.possedeCommeAscendant(p)) {
				return (1 + this.pere.distanceDAscendance_aux(p));
			}
			return (0);
		}

		if (this.mere.possedeCommeAscendant(p))
			return (1 + this.mere.distanceDAscendance_aux(p));

		if (this.pere.possedeCommeAscendant(p))
			return (1 + this.pere.distanceDAscendance_aux(p));
		
		return (0);
	}

	public void afficheAscendantUn(Personne p) {
		if (p == null)
			return ;

		if (!this.possedeCommeAscendant(p)) {
			System.out.print("Malheuresement ce personnage n'a pas d'Ascendance :(");
			return ;
		}


		if (pere == null && mere == null)
			return ;

		if (this.equals(p)) {	
			System.out.print("enfant de " + this.prenom + " " + this.nomDeFamille + ", ");
			return ;
		}


		if (this.pere == null) {
			if (this.mere.possedeCommeAscendant(p)) {
				System.out.print("enfant de " + this.mere.prenom + " " + this.mere.nomDeFamille + ", ");
				this.mere.afficheAscendantUn(p);
			}
			return ;
		}

		if (this.mere == null) {
			if (this.pere.possedeCommeAscendant(p)) {
				System.out.print("enfant de " + this.pere.prenom + " " + this.pere.nomDeFamille + ", ");
				this.pere.afficheAscendantUn(p);
			}
			return ;
		}

		if (this.mere.possedeCommeAscendant(p)) {
			System.out.print("enfant de " + this.mere.prenom + " " + this.mere.nomDeFamille + ", ");
			this.mere.distanceDAscendance(p);
		}

		if (this.pere.possedeCommeAscendant(p)) {
			System.out.print("enfant de " + this.pere.prenom + " " + this.pere.nomDeFamille + ", ");
			this.pere.distanceDAscendance(p);
		}
		return ;
	}


	public int distanceDAscendance(Personne p) {
		if (this.distanceDAscendance_aux(p) == -1)
			return (p.distanceDAscendance_aux(this));
		return (this.distanceDAscendance_aux(p));
	}




	public static void main(String[] args) {
		Personne p1 = new Personne("P1", "N1", new Personne("p2", "n2"), new Personne("p3", "n3"));
		System.out.println("p1.nbAscendants = " + p1.nbAscendants() + "\n\n");
		System.out.println("p1.possedeCommeAscendant(p1.pere) = " + p1.possedeCommeAscendant(p1.pere) + "\n\n");
		System.out.println("p1.distanceDAscendance(p1.pere) = " + p1.distanceDAscendance(p1.pere) + "\n\n");	
		System.out.println("p1.pere.distanceDAscendance(p1) = " + p1.pere.distanceDAscendance(p1) + "\n\n");
		System.out.println("p1.afficheAscendantUn(p1.pere) = ");
		p1.afficheAscendantUn(p1.pere);
		System.out.println("\n");
	}






}
