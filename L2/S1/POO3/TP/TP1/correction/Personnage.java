import java.util.Random;

/* Partie 2 de l'exercice */
public class Personnage{
    
    private String nom;
    private Informations etatInitial;
    private Informations etatActuel;
    
    public Personnage(String nom, int v, int f, int a){
        this.nom = nom;
        etatInitial = new Informations(v,f,a);
        rebirth();
    }
    
    public String toString(){
        
        String result = nom + ":";
        result += "\n\t Etat initial : " + etatInitial.toString() + "\n";
        result += "\t Etat actuel : " + etatActuel.toString() + "\n";
        return result;
    }
    
    public boolean estVivant(){
        return (etatActuel.getVitalite() > 0);
    }
    
    public void rebirth(){
        etatActuel = new Informations(etatInitial);
    }
    
    public void attaque(Personnage def){
        
        int n = (int) (Math.random() * Math.max(1, etatActuel.getForce() - def.etatActuel.getForce() - 1)) + 1;
        
        if(etatActuel.getAgilite() > def.etatActuel.getAgilite()){
            def.etatActuel.setVitalite(def.etatActuel.getVitalite() - n);
            System.out.println(def.nom+" subit "+n+" dégâts!");
        }
        else{
            def.etatActuel.setVitalite(def.etatActuel.getVitalite() - n/2);
            def.etatActuel.setAgilite(def.etatActuel.getAgilite() - n/3);
            System.out.println(def.nom+" ne subit que "+n/2+" dégâts mais son agilité est réduite...");
        }
        if (def.etatActuel.getVitalite() <= 0) {
            System.out.println(def.nom+" est mort!");
        }
    }
    
    public static void lutteIte(Personnage attaquant, Personnage defenseur){
        
        while(attaquant.estVivant() && defenseur.estVivant()){
            attaquant.attaque(defenseur);
            Personnage tmp = attaquant;
            attaquant = defenseur;
            defenseur = tmp;
        }
    }
    
    public static void lutteRec(Personnage attaquant, Personnage defenseur){
            
            if (attaquant.estVivant() && defenseur.estVivant()) {
                attaquant.attaque(defenseur);
                lutteRec(defenseur,attaquant);
            }
    }

}
