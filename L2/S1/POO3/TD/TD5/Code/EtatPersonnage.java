public abstract class EtatPersonnage {
    abstract int alteration(int pdv);
    
    public EtatPersonnage clone() throws CloneNotSupportedException {
	return (EtatPersonnage) super.clone();
    }
    
    public boolean equals(Object o) {
	return this.getClass() == o.getClass();
    }
}
