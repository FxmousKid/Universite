public class Salon {
    public  Utilisateur[] tabUtilisateur ;
    public  Message[] taBMessage;
    public int indexLibreUtilisateur;
    public int indexLibreMessage;

    public Salon(int nbuser, int nbmessage) {
        this.tabUtilisateur = new Utilisateur[10];
        this.taBMessage = new Message[10];
        this.indexLibreMessage = 0;
        this.indexLibreUtilisateur = 0;
    }

    public void append_message(Message m1)
    {
        this.taBMessage[this.indexLibreMessage] = m1;
        this.indexLibreMessage++;
    }
    
    public void append_user( Utilisateur user)
    {
        this.tabUtilisateur[this.indexLibreUtilisateur ] = user;
        this.indexLibreUtilisateur++;
    }

    public boolean estPresent(Utilisateur u1) {
        for (Utilisateur user : this.tabUtilisateur) {
            if (user != null)
                if (user.getPseudonyme().equals(u1.getPseudonyme())) {
                    return true;
                }
        }
        return false;
    }

    public void ajouterUtilisateur(Utilisateur u1) {
        append_user(u1);
        this.indexLibreUtilisateur += 1; 
    }

    public void ajouterMessage(Message m1) {
        if (estPresent(m1.sender) == true && indexLibreMessage < 10) {
            this.indexLibreMessage += 1;
            append_message(m1);
        }
    }

    public void afficher() {
        System.out.println("nidexmesage = " + indexLibreMessage );
        for (int i = 0; i < this.indexLibreMessage; i++) {
            System.out.println(this.taBMessage[i].sender.getPseudonyme() + ": " + this.taBMessage[i].content);
        }
    }

}