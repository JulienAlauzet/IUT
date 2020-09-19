package fr.umontpellier.iut.svg;

public class Circle extends Element {
    private int cx;
    private int cy;
    private int r;

    public Circle(String name, int cx, int cy, int r) {
        super(name);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
     public String getParameters() {
        return "cx=\"" + cx + "\" cy=\"" + cy +"\" r=\"" + r + "\"";
     }


}
