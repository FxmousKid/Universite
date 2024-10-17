public abstract class Action implements Cloneable {    
    public abstract int alterationSource();
    public abstract int alterationCible();
    
    public Action clone() throws CloneNotSupportedException {
	return (Action) super.clone();
    }
    
    public boolean equals(Object o) {
	return this.getClass() == o.getClass();
    }
}
