package fr.umontpellier.iut.svg;

public class Translate implements Transformation {

    private int tx;
    private int ty;

    public Translate(int tx, int ty) {
        this.tx = tx;
        this.ty = ty;
    }

    @Override
    public String toString() {
        return "translate(" + tx + ", " + ty + ") ";
    }

}
