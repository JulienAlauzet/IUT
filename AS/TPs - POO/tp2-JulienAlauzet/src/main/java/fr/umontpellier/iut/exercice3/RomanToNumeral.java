package fr.umontpellier.iut.exercice3;

public class RomanToNumeral {

    public int getNumeral(String nombreRomain) {
        int res = 0;
        if (nombreRomain.contains("IV")) {
            res += 4;
            nombreRomain = nombreRomain.replace("IV", "");
        }
        if (nombreRomain.contains("IX")) {
            res += 9;
            nombreRomain = nombreRomain.replace("IX", "");
        }
        if (nombreRomain.contains("XL")) {
            res += 40;
            nombreRomain = nombreRomain.replace("XL", "");
        }
        if (nombreRomain.contains("XC")) {
            res += 90;
            nombreRomain = nombreRomain.replace("XC", "");
        }
        if (nombreRomain.contains("CD")) {
            res += 400;
            nombreRomain = nombreRomain.replace("CD", "");
        }
        if (nombreRomain.contains("CM")) {
            res += 900;
            nombreRomain = nombreRomain.replace("CM", "");
        }
        for (int i = nombreRomain.length() - 1; i >= 0; i--) {
            if (nombreRomain.charAt(i) == 'I')
                res += 1;
            else if (nombreRomain.charAt(i) == 'V')
                res += 5;
            else if (nombreRomain.charAt(i) == 'X')
                res += 10;
            else if (nombreRomain.charAt(i) == 'L')
                res += 50;
            else if (nombreRomain.charAt(i) == 'C')
                res += 100;
            else if (nombreRomain.charAt(i) == 'D')
                res += 500;
            else if (nombreRomain.charAt(i) == 'M')
                res += 1000;
        }
        return res;
    }
}


