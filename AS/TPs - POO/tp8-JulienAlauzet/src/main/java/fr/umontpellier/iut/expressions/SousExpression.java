package fr.umontpellier.iut.expressions;

public class SousExpression implements Expression {

    private char operateur;
    private Expression sousEx1;
    private Expression sousEx2;

    public SousExpression(char operateur, Expression sousEx1, Expression sousEx2) {
        this.operateur = operateur;
        this.sousEx1 = sousEx1;
        this.sousEx2 = sousEx2;
    }

    @Override
    public double calculerValeur() {
        switch (operateur) {
            case '+' : return (sousEx1.calculerValeur() + sousEx2.calculerValeur());
            case '-' : return (sousEx1.calculerValeur() - sousEx2.calculerValeur());
            case '/' : if (sousEx2.calculerValeur() != 0) return (sousEx1.calculerValeur() / sousEx2.calculerValeur());
                        else throw new RuntimeException("Division par 0 impossible");
            case '*' : return (sousEx1.calculerValeur() * sousEx2.calculerValeur());
            default : throw new RuntimeException("Opérateur non-reconnu");
        }
    }

    @Override
    public String toString() {
        return "(" + sousEx1 + operateur + sousEx2 + ")";
    }
}
