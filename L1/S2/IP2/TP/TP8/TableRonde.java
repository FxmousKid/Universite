public class TableRonde {
	private CellRob courant;

	public TableRonde(Robot courant) {
		CellRob cel = new CellRob(courant);
		this.courant = cel;
	}

	public void affiche() {
		CellRob debut = this.courant;
		do { 
			System.out.println(this.courant.getRobot().description());
			this.courant = this.courant.getCelSuivant();
		}
		while (this.courant != debut);
	}

	public void ajouteRob(Robot R) {
		CellRob new_last = new CellRob(R, this.courant, this.courant.getCelPrecedente());
		this.courant.getCelPrecedente().setCelSuivant(new_last);
		this.courant.setCelPrecedent(new_last);
	}

	public void supprimerCellule(CellRob cel) {
		cel.getCelSuivant().setCelPrecedent(cel.getCelPrecedente());
		cel.getCelPrecedente().setCelSuivant(cel.getCelSuivant());
	}

	public boolean supprimer(int id) {
		CellRob iterateur = this.courant;
		if (iterateur.getRobot().getId() == id && this.courant.getCelSuivant() == this.courant) {
			this.courant = new CellRob(null, null, null);
			return true;
		}
		if (iterateur.getRobot().getId() == id) {
			supprimerCellule(iterateur);
			return true;
		}
		iterateur = iterateur.getCelSuivant();
		while (iterateur.getRobot().getId() != id && iterateur != this.courant) {
			iterateur = iterateur.getCelSuivant();
		}
		if (this.courant == iterateur) {
			return false;
		}
		// if we're here this means that we found our id somewhere in the list.
		supprimerCellule(iterateur);
		return true;
	}
	
	public boolean supprimer(char nom) {
		CellRob iterateur = this.courant;
		if (iterateur.getRobot().getNom() == nom && this.courant.getCelSuivant() == this.courant) {
			this.courant = new CellRob(null, null, null);
			return true;
		}
		if (iterateur.getRobot().getNom() == nom) {
			supprimerCellule(iterateur);
			return true;
		}
		iterateur = iterateur.getCelSuivant();
		while (iterateur.getRobot().getNom() != nom && iterateur != this.courant) {
			iterateur = iterateur.getCelSuivant();
		}
		if (this.courant == iterateur) {
			return false;
		}
		// if we're here this means that we found our nom somewhere in the list.
		supprimerCellule(iterateur);
		return true;
	}


}



