package fr.umontpellier.iut.svg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Modélisation des paramètres de style d'une balise SVG
 */
public class Style {
    /**
     * Couleur de remplissage
     */
    private String fill;
    /**
     * Couleur du tracé
     */
    private String stroke;
    /**
     * Épaisseur du trait
     */
    private Double strokeWidth;
    /**
     * Transparence du remplissage
     */
    private Double fillOpacity;

    private ArrayList<Transformation> transformations;

    public Style() {
        this.transformations = new ArrayList<>();
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public void setStrokeWidth(Double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    public void addTransform(Transformation t) {
        transformations.add(t);
    }

    /**
     * Renvoie la représentation du style sous forme d'une chaîne de caractères qui peut être insérée dans une
     * balise SVG.
     *
     * @return représentation du style au format SVG
     */
    public String toSVG() {
        StringJoiner elements = new StringJoiner(" ");
        if (fill != null) {
            elements.add("fill=\"" + fill + "\"");
        }
        if (stroke != null) {
            elements.add("stroke=\"" + stroke + "\"");
        }
        if (strokeWidth != null) {
            elements.add("stroke-width=\"" + strokeWidth + "\"");
        }
        if (fillOpacity != null) {
            elements.add("fill-opacity=\"" + fillOpacity + "\"");
        }
        if (!transformations.isEmpty()) {
            String texte="";
            for (Transformation t : transformations) {
                texte += t;
            }
            elements.add("transform=\"" + texte + "\"");
        }

        return elements.toString();
    }
}
