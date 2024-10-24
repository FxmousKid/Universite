//package org.fxmouskid;

public class Ellipse extends Forme {

    /* Constructeur */
    public Ellipse(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public double surface() {
        return Math.PI * this.getHeight() * this.getWidth();
    }
}
