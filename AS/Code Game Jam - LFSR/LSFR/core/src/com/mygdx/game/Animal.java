package com.mygdx.game;

import java.lang.Thread;

public class Animal {

    private static Animal [] tabAnimaux = new Animal [100];
    private static int nbAnimaux = 0;
    private static int[] nbIndiv = {0,0,0};
    
    private static final String[]nom = {"Ecureuil","Oiseau","Ours"};
    private static final double []tabDuree = {1000 , 500 , 2000};      // valeurs initiales ; un aller en ms
    private static double []tabCharge = {2 , 1 , 4};   // valeurs initiales

    private int id;
    private int type;                                // numéro représentant l'animal
    private static int [] niveau = { 1 , 1 , 1 };
    private double duree;
    private double solde;

    private int etat;
    private int zone;

    private static final double [] coutsActivation = { 100 , 200 };
	
    public Animal(int i){  //constuction animal niveau 1 en fonction de i (type)
	this.type = i;
	this.duree = this.tabDuree[i];
	this.tabAnimaux[nbAnimaux]=this;
	this.id = nbAnimaux;
	this.nbAnimaux++;
	this.solde=0;
	this.nbIndiv[i]++;
	this.zone=this.id;
	this.etat=4;
	
    }

    public static void lvlUp (int type) {  // Multiplication de tout par 3 pour le moment
	if (estSolvable(type) && niveau[type] < 3 ){
	    tabCharge[type]*= 4;
	    Zone.getTabZones()[4].retraitSoldeZone(coutsActivation[niveau[type]-1]);
	    niveau[type]++;
	}
    }

    public String toString () {
	return ("Animal n°" + (this.id+1) + " : " + this.nom[this.type] +
		" \nNiveau : " + this.niveau[this.type] +
		"\nDurée de trajet : " + this.duree +
		" ms\nCharge : " + this.tabCharge[this.type]+
		"\nSolde : "+this.solde+
		"\nZone d'affectation : "+this.zone+
		"\nEtat : "+this.etat+"\n\n");
    }

    public static String toStringAnimal(int i){
	return "Niveau : "+niveau[i]+
	    "\nCharge : "+tabCharge[i]+
	    "\nDurée de trajet : "+(tabDuree[i]/1000)+" s\n";
    }

    public static Animal getAnimalById ( int i ){
	return tabAnimaux[i];
    }

    public int getId () {
	return this.id;
    }

    public int getType () {
	return this.type;
    }

    public static int getNbAnimaux (){
	return nbAnimaux;
    }
    
    public static int getNbEcureuil (){
	return nbIndiv[0];
    }

    public static int getNbOiseau (){
	return nbIndiv[1];
    }

    public static int getNbOurs (){
	return nbIndiv[2];
    }

    public double getSolde(){
	return this.solde;
    }
    
    public void setSolde(double i){
	this.solde = i;
    }

    public static String affIndiv(){
	return "Nombre d'animaux : "+ nbAnimaux +
	    "\nNb d'Ecureuil : "+nbIndiv[0]+
	    "\nNb d'Oiseau : "+nbIndiv[1]+
	    "\nNb d'Ours : "+nbIndiv[2];
    }

    public void setZone(int newZone){
	this.zone=newZone;
    }

    public void deplacement (){
	switch(this.etat){
	case 4:
	    this.etat = 9+this.zone;
	    break;
	case 0: case 1: case 2: case 3: case 5: case 6: case 7: case 8:
	    this.etat = 18+this.zone;
	    break;
	case 9: case 10: case 11: case 12: case 14: case 15: case 16: case 17:
	    this.etat = this.zone;
	    break;
	case 18: case 19: case 20: case 21: case 23: case 24: case 25: case 26:
	    this.etat = 4;
	    break;
	}
    }

    public void comportement(){
	switch(this.etat){
        case 4:
	    Zone.getZoneById(this.etat).ajoutSoldeZone(this.solde);
	    this.solde=0;
	    this.deplacement();
	    break;
	case 0: case 1: case 2: case 3: case 5: case 6: case 7: case 8:
	    if (Zone.getZoneById(this.zone).getSoldeZone() < this.tabCharge[this.type]){
		this.solde=Zone.getZoneById(this.zone).getSoldeZone();
		Zone.getZoneById(this.zone).setSoldeZone(0);
	    }
	    else{
		this.solde=this.tabCharge[this.type];
		Zone.getZoneById(this.zone).retraitSoldeZone(this.tabCharge[this.type]);
	    }
	    this.deplacement();
	    break;
	case 9: case 10: case 11: case 12: case 14: case 15: case 16: case 17:
	    this.deplacement();
	    break;
	case 18: case 19: case 20: case 21: case 23: case 24: case 25: case 26:
	    this.deplacement();
	    break;
	}
    }

    public static boolean estSolvable(int type) {
	return (Zone.getTabZones()[4].getSoldeZone() >= coutsActivation[niveau[type]-1]);
    }

    public static String getCouts(int type){
    	return String.valueOf(coutsActivation[niveau[type]-1]);
	}

	public static double[] getTabDuree() {
		return tabDuree;
	}

	public int getZone() {
		return zone;
	}
}

