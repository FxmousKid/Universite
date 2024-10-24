//package org.fxmouskid;

public class Rectangle extends Forme {

    public Rectangle(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    @Override
    public double surface() {
        return getHeight() * getWidth();
    }

}
