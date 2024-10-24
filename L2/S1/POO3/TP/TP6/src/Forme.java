//package org.fxmouskid;

public abstract class Forme {
	/* coordonnées du centre la forme dans le plan */
	private double x;
	private double y;

	/* longeur et largeur de la forme */
	private double height;
	private double width;

	/* constructeur */
	public Forme(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	/* Getters to access our private attirbutes */
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

	@Override
	public String toString() {
		String rendue = this.getClass().getSimpleName() + " : ";
		rendue += "[x=" + this.x + ", y=" + this.y + ", height=" + this.height;
		rendue += ", width=" + this.width + "]";
		return rendue;
	}

	/* A surface area calculating method */
	public abstract double surface();
}