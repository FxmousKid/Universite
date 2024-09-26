public class Horloge {
    private CompteurCyclique heures, minutes;

    public Horloge(int h, int m) {
	heures = new CompteurCyclique(24, h);
        minutes = new CompteurCyclique(60, m);
    }

    public void setHeure(int h, int m) {
        heures.setValeur(h);
	minutes.setValeur(m);
    }

    public void setHeure(int h) {
        heures.setValeur(h);
    }

    public void incrementer() {
        if (minutes.incrementer()) {
            heures.incrementer();
        }
    }

    @Override
    public String toString() {
        return heures.toString() + ":" + minutes.toString();
    }
}
