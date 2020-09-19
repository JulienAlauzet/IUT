package fr.umontpellier.iut.expressions;

public class AppExpression {

    public static void main(String[] args) {
        Expression monExpr;
        Expression nb1 = new Nombre(2);
        Expression nb2 = new Nombre(3);
        Expression nb3 = new Nombre(5);
        Expression ssEx1 = new SousExpression('-', nb1, nb2);
        monExpr = new SousExpression('*', ssEx1, nb3);
        System.out.println(monExpr.toString() + " = " + monExpr.calculerValeur());
    }
}
