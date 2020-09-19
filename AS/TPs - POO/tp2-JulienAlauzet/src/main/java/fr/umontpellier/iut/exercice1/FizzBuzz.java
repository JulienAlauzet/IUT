package fr.umontpellier.iut.exercice1;

public class FizzBuzz {

    public static String getValue(int i) {
        String res = "";
        if (i % 3 == 0 || i % 5 ==0) {
            if (i % 3 == 0)
                res += "Fizz";
            if (i % 5 == 0)
                res += "Buzz";
        }
        else
            res = String.valueOf(i);
        return res;
    }

    public static String[] computeList(int i) {
        String[] res = new String[i];
        for (int j = 0; j < i; j++) {
            res[j] = getValue(j + 1);
        }
        return res;
    }
}
