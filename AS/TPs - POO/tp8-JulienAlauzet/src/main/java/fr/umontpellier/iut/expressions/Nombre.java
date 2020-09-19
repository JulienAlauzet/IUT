package fr.umontpellier.iut.expressions;

public class Nombre implements Expression {

    private double nombre;

    public Nombre(double nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ""+nombre;
    }

    @Override
    public double calculerValeur() {
        return nombre;
    }

}
