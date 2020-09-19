package fr.umontpellier.iut.svg;

import java.util.ArrayList;

public class Group extends Element {

    private ArrayList<Element> groupe;

    public Group() {
        super("g");
        groupe = new ArrayList<Element>();
    }


    public void add(Element element) {
        groupe.add(element);
    }


    public String getContent() {
        String res ="";
        for (Element element :
                groupe) {
            res += element.toSVG();
        }
        return res;
    }

}
