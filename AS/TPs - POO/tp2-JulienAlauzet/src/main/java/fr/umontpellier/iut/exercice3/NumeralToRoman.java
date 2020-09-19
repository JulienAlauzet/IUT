package fr.umontpellier.iut.exercice3;

class NumeralToRoman {

    String getRoman(int nombre){
        String res = "";

        while (nombre >= 1000) {
            res += 'M';
            nombre -= 1000;
        }
        if (nombre >= 900) {
            res += "CM";
            nombre -= 900;
        }
        if (nombre >= 500) {
            res += 'D';
            nombre -= 500;
        }
        if (nombre >= 400) {
            res += "CD";
            nombre -= 400;
        }
        while (nombre >= 100) {
            res += 'C';
            nombre -= 100;
        }
        if (nombre >= 90) {
            res += "XC";
            nombre -= 90;
        }
        if (nombre >= 50) {
            res += 'L';
            nombre -= 50;
        }
        if (nombre >= 40) {
            res += "XL";
            nombre -= 40;
        }
        while (nombre >= 10) {
            res += 'X';
            nombre -= 10;
        }
        if (nombre >= 9) {
            res += "IX";
            nombre -= 9;
        }
        if (nombre >= 5) {
            res += 'V';
            nombre -= 5;
        }
        if (nombre >= 4) {
            res += "IV";
            nombre -= 4;
        }
        while (nombre >= 1) {
            res += 'I';
            nombre -= 1;
        }

        return res;
    }
}
