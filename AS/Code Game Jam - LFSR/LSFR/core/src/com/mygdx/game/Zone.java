package com.mygdx.game;


import com.mygdx.Ut;

import java.util.*;


public class Zone {

    private int id;
    private boolean etat;
    private double prod;
    private double soldeZone;
    private int nbAnimauxZone;
    private static final String[] typeZoneTab = {"Classique","Savane","Marécageuse","Enneigée", "Dépôt"};
    private int typeZone;
    private static final double[] ratioEcureuil={0.25,1,2,4};
    private static final double[] ratioOiseau={1,2,0.5,4};
    private static final double[] ratioOurs={1,4,2,0.5};
    private Animal [] tabAnimauxZone;
    private static Zone [] tabZones = new Zone [9];
    private static int nbZones = 0;
    private int [] coordonnees;
    private static int nbZonesActives = 0;
    private int nbAnimauxMax;
    private static final double[] coutsActivation = { 0, 10 , 20 , 50 , 0 , 100 , 200, 400 , 1000 };
    

    public Zone () {
        this.id=this.nbZones;
	this.etat = false;
	this.tabAnimauxZone = new Animal[2];
	if ( this.id == 4 ){
	    this.prod=0;
	    this.typeZone=4;
	    this.nbAnimauxMax=0;
		this.soldeZone = 0;
	}
	else{
	    this.prod=this.id+1;
	    this.typeZone= Ut.randomMinMax(0,3);
	    this.nbAnimauxMax=2;
		this.soldeZone = 1000000;
	}
	this.nbAnimauxZone=0;
	this.tabZones[this.id]=this;
	this.nbZones++;
	this.coordonnees=affectationCoordonnees();

    }

    public void setSoldeZone(double total){
	this.soldeZone=total;
    }
    
    public double getSoldeZone(){
	return this.soldeZone;
    }

    public void ajoutSoldeZone(double ajout){
	this.soldeZone+=ajout;
    }

    public void retraitSoldeZone(double retrait){
	this.soldeZone-=retrait;
    }
    
    public  int[] affectationCoordonnees(){
	int [] tab = new int [2];
	switch(this.id){
	case 0:
	    tab[0]=0;
	    tab[1]=0;
	    break;
	case 1:
	    tab[0]=0;
	    tab[1]=1;
	    break;
	case 2:
	    tab[0]=0;
	    tab[1]=2;
	    break;
	case 3:
	    tab[0]=1;
	    tab[1]=0;
	    break;
	case 4:
	    tab[0]=1;
	    tab[1]=1;
	    break;
	case 5:
	    tab[0]=1;
	    tab[1]=2;
	    break;
	case 6:
	    tab[0]=2;
	    tab[1]=0;
	    break;
	case 7:
	    tab[0]=2;
	    tab[1]=1;
	    break;
	case 8:
	    tab[0]=2;
	    tab[1]=2;
	    break;
	}
	return tab;
    }

    public String toString(){
        return "id: " + this.getId() +
	    "\nEtat: " + this.getEtat() +
	    "\nNbAnimaux: " + this.getNbAnimauxZone() +
	    "\nTypeZoneTab: " + this.getTypeZoneTab() +
	    "\nProd : " +this.prod +
	    "\nCoordonnées : " + this.coordonnees[0]+ " - " + this.coordonnees[1] +
	    "\nSolde : "+this.soldeZone+"\n\n" + affichAnimauxZone() + "\n";
    }

    public String affichAnimauxZone() {
	String res="";
	if (this.nbAnimauxZone == 0){
	    res+="Aucun animal";
	}
	else{
	    for ( int i = 0 ; i < this.nbAnimauxZone ; i++ ){
		res+=this.tabAnimauxZone[i];
	    }
	}
	return res;
    }
    
    public static int getNbZones (){
	return nbZones;
    }

    public static int getNbZonesActives (){
	return nbZonesActives;
    }
    
    public static Zone getZoneById ( int i ){
	return tabZones[i];
    }

    public void activer() {
	if (estSolvable() /*&& estActivable()*/){
	    this.etat=true;
	    this.nbZonesActives++;
	
	    tabZones[4].retraitSoldeZone(coutsActivation[this.id]);
	    this.tabAnimauxZone[0] = new Animal (Ut.randomMinMax(0,2));
	    this.nbAnimauxZone++;
	}
		AffZone.getTab()[this.id] = typeZone;
    }

    public boolean estSolvable() {
	return (tabZones[4].getSoldeZone() >= coutsActivation[this.id]);
    }

    /*public boolean estActivable(){
	if (!this.getEtat()){
	    if (this.id!=5 || this.id!=0){
		return (tabZones[this.id-1].getEtat());
	    }
	    else {
		return (tabZones[this.id-2].getEtat());
	    }
	}
	else {
	    return false;
	}
    }*/
    
    public int getId(){
	return this.id;
    }

    public boolean getEtat(){
	return this.etat;
    }

    public int getNbAnimauxZone(){
	return this.nbAnimauxZone;
    }

    public String getTypeZoneTab(){
	return this.typeZoneTab[this.getTypeZone()];
    }
    
    public int getTypeZone(){
	return this.typeZone;
    }

    public String toStringDebloque(){
	return ("Bravo ! Vous avez débloqué une zone de type "+typeZoneTab[this.typeZone]);
    }

    public Animal[] getTabAnimauxZone(){
        return this.tabAnimauxZone;
    }

    public static Zone [] getTabZones(){
	return tabZones;
    }
    
    public boolean estPleine (){
	if ( this.id == 4 ){
	    return true;
	}
	else{
	    return ( this.nbAnimauxZone == 2 );
	}
    }

	
    public void affectation ( Animal a , Zone z ){
        z.tabAnimauxZone[z.nbAnimauxZone] = a;
	z.nbAnimauxZone++;
	a.setZone(z.getId());	
    }

    public void suppression ( Animal a ){
	int place=0;
	for ( int i = 0 ; i < 3 ; i++ ) {
	    if ( this.tabAnimauxZone[i].getId() == a.getId() ){
		place = i;
		break;
	    }
	}
	this.tabAnimauxZone[place] = this.tabAnimauxZone[nbAnimauxZone - 1];
	this.nbAnimauxZone--;
    }

    public void reaffectation(Animal a, Zone z){
	affectation(a,z);
	suppression(a);
    }
	
}
