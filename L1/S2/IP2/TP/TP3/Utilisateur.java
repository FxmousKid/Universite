public class Utilisateur {

    private String pseudo;
    private String motDePasse;
    private final String adresseMail;
    
    public Utilisateur(String p, String m, String a) {
        this.pseudo = p;
        this.motDePasse = m;
        this.adresseMail = a;
    }

    public boolean testMotDePasse(String ancien) {
        return ancien.equals(this.motDePasse);
    }
    
    public void changerMotDePasse(String motDePassetest, String nouveauMotDePasse) {
        if (motDePassetest.equals(this.motDePasse)) {
            this.motDePasse = nouveauMotDePasse;
        }
    } 

    public String getPseudonyme() {
        return (this.pseudo);
    }

    public void setPseudonyme(String MDP, String nvPseudo) {
        if (MDP.equals(this.motDePasse)) {
            this.pseudo = nvPseudo;
        }
    }
}