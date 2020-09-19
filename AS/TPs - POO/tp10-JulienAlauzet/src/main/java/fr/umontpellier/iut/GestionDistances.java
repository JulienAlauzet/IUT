package fr.umontpellier.iut;

import java.util.HashMap;
import java.util.Map;

public final class GestionDistances {
    public static final Map<String, Integer> dico = new HashMap<>();

    static {
        dico.put("Montpellier", new Integer(0));
        dico.put("Sète", new Integer(36));
        dico.put("Sommières", new Integer(30));
        dico.put("Nîmes", new Integer(58));
        dico.put("Lunel", new Integer(30));
        dico.put("Béziers", new Integer(80));
    }

    public static int getDistance(String ville) {
        return dico.get(ville);
    }
}
