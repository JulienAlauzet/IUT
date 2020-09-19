package fr.umontpellier.iut.svg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {

    @Test
    public void toSVGTest_Circle() {
        Circle c1 = new Circle ("circle", 0, 0, 5);
        assertEquals(c1.toSVG(), "<circle cx=\"0\" cy=\"0\" r=\"5\" />");
    }

    @Test
    public void toSVGTest_Rectangle() {
        Rectangle r1 = new Rectangle("rectangle", 0,0,5, 5);
        assertEquals(r1.toSVG(), "<rect x=\"0\" y=\"0\" width=\"5\" height=\"5\" />");
    }
}