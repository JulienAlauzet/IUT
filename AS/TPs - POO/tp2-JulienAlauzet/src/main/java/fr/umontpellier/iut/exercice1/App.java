package fr.umontpellier.iut.exercice1;

public class App {

    public static void main(String[] args) {
        String[] tab = FizzBuzz.computeList(20);
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + ", ");
        }
    }

}
