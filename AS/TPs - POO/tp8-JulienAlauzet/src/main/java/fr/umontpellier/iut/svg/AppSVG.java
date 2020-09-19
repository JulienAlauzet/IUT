package fr.umontpellier.iut.svg;

public class AppSVG {
    public static void main(String[] args) {
        SVG svg11 = new SVG(600, 575);
        Circle c1 = new Circle("circle", 200, 200, 200);
        Circle c2 = new Circle("circle", 200, 200, 200);
        Circle c3 = new Circle("circle", 200, 200, 200);
        Transformation translate = new Translate(200, 0);
        Transformation rotate = new Rotate(60, 200, 200);
        c2.getStyle().addTransform(translate);
        c3.getStyle().addTransform(rotate);
        c3.getStyle().addTransform(translate);
        Group g = new Group();
        g.getStyle().setFillOpacity(0.5);
        g.getStyle().setStrokeWidth(5.0);
        g.getStyle().setStroke("black");
        c1.getStyle().setFill("green");
        c2.getStyle().setFill("blue");
        c3.getStyle().setFill("red");
        g.add(c1);
        g.add(c2);
        g.add(c3);
        svg11.add(g);
        svg11.saveAsFile("svg11");
    }
}