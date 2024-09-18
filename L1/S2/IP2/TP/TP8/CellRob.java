public class CellRob {
	private Robot robot;
	private CellRob cel_suivant;
	private CellRob cel_precedent;

	public CellRob(Robot rob) {
		this.robot = rob;
		this.cel_suivant = this;
		this.cel_precedent = this;
	}

	public CellRob(Robot robot, CellRob cel_suivant, CellRob cel_precedent) {
		this.robot = robot;
		this.cel_precedent = cel_precedent;
		this.cel_suivant = cel_suivant;
	}

	public Robot getRobot() {
		return this.robot;
	}

	public void setRobot(Robot rob) {
		this.robot = rob;
	}

	public CellRob getCelSuivant() {
		return this.cel_suivant;
	} 

	public CellRob getCelPrecedente() {
		return this.cel_precedent;
	}

	public void setCelSuivant(CellRob cel) {
		this.cel_suivant = cel;
	}

	public void setCelPrecedent(CellRob cel) {
		this.cel_precedent = cel;
	}
}
