public class Informations{
    
    private int vitalite;
    private int force;
    private int agilite;
    
    public Informations(int v, int f, int a){
        vitalite = v;
        force = f;
        agilite = a;
    }
    
    public Informations(Informations inf){
        vitalite = inf.vitalite;
        force = inf.force;
        agilite = inf.agilite;
    }
    
    //asseseurs
    public int getVitalite(){
        return vitalite;
    }
    
    public int getForce(){
        return force;
    }
    
    public int getAgilite(){
        return agilite;
    }
    
    //modifieurs
    public void setVitalite(int x){
        vitalite = x;
    }
    public void setForce(int x){
        force = x;
    }
    public void setAgilite(int x){
        agilite = x;
    }
    
    public String toString(){
        return "{vitalite : " + vitalite + ", force : " + force + ", agilite : " + agilite + "}";
    }
    
}
