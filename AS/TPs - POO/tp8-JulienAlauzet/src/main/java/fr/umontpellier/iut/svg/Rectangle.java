package fr.umontpellier.iut.svg;

public class Rectangle extends Element {

    private int x;
    private int y;
    private int rx;
    private int ry;
    private int width;
    private int height;

    public Rectangle(String name, int x, int y, int width, int height) {
        super(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name, int x, int y, int width, int height, int rx, int ry) {
        super(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String getParameters() {
        if (rx != 0 || ry != 0)
            return "x=\"" + x + "\" y=\"" + y +"\" width=\"" + width + "\" height=\"" + height + "\" rx=\"" + rx + "\" ry=\"" + ry + "\"";
        else
            return "x=\"" + x + "\" y=\"" + y +"\" width=\"" + width + "\" height=\"" + height + "\"";
    }

}
