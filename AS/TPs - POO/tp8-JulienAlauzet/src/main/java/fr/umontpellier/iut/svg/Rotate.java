package fr.umontpellier.iut.svg;

public class Rotate implements Transformation {

    private int rangle;
    private int rx;
    private int ry;


    public Rotate(int rangle, int rx, int ry) {
        this.rangle = rangle;
        this.rx = rx;
        this.ry = ry;
    }

    public Rotate(int rangle) {
        this.rangle = rangle;
    }

    @Override
    public String toString() {
        if (rx != 0 || ry != 0)
            return "rotate(" + rangle + " " + rx + " " + ry + ") ";
        else
            return "rotate(" + rangle + ") ";
    }
}
