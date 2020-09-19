package fr.umontpellier.iut.svg;

public class Scale implements Transformation {

    private double sx;
    private double sy;

    public Scale(double sx, double sy) {
        this.sx = sx;
        this.sy = sy;
    }

    @Override
    public String toString() {
        return "scale(" + sx + " " + sy + ") ";
    }
}
