package tamagoshi.tamagoshis;

/**
 * La classe GrosMangeur modélise un Tamagoshi qui mange plus.<br>
 * Cette classe hérite de la classe Tamagoshi<br>
 * Ce Tamagoshi consomme deux fois plus d'énergie au cours d'un cycle
 * 
 * @see Tamagoshi
 * @author alauzetj
 */

import tamagoshi.exceptions.NullExpressionRunTimeException;

public class GrosMangeur extends Tamagoshi {

	/**
	 * Constructeur pour la classe GrosMangeur<br>
	 * Identique à celui de la classe mère
	 * 
	 * @param name Le nom du GrosMangeur
	 * @throws NullExpressionRunTimeException si le nom est null
	 */
	public GrosMangeur(String name) throws NullExpressionRunTimeException {
		super(name);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructeur pour la classe GrosMangeur<br>
	 * Identique à celui de la classe mère : nom tiré aléatoirement dans une liste statique
	 * @throws NullExpressionRunTimeException si le nom attribué est null
	 */
	public GrosMangeur() throws NullExpressionRunTimeException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	/**
	 * Fait consommer de l'énergie au GrosMangeur<br>
	 * Identique à la méthode de la classe mère, mais consomme un point d'énergie supplémentaire
	 * @return un booléen : true s'il lui reste de l'énergie, false sinon
	 */
	public boolean consommeEnergie() {
		energy--;
		return super.consommeEnergie();
	}
	
	

}
