package tamagoshi.tamagoshis;

/**
 * La classe GrosJoueur modélise un Tamagoshi qui joue plus.<br>
 * Cette classe hérite de la classe Tamagoshi<br>
 * Ce Tamagoshi consomme deux fois plus de fun au cours d'un cycle
 * 
 * @see Tamagoshi
 * @author alauzetj
 */

import tamagoshi.exceptions.NullExpressionRunTimeException;

public class GrosJoueur extends Tamagoshi{

	/**
	 * Constructeur pour la classe GrosMangeur<br>
	 * Identique à celui de la classe mère
	 * 
	 * @param name Le nom du GrosJoueur
	 * @throws NullExpressionRunTimeException si le nom est null
	 */
	public GrosJoueur(String name) throws NullExpressionRunTimeException {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructeur pour la classe GrosJoueur<br>
	 * Identique à celui de la classe mère : nom tiré aléatoirement dans une liste statique
	 * @throws NullExpressionRunTimeException si le nom attribué est null
	 */
	public GrosJoueur() throws NullExpressionRunTimeException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Fait consommer de l'énergie au GrosMangeur<br>
	 * Identique à la méthode de la classe mère, mais consomme un point d'énergie supplémentaire
	 * @return un booléen : true s'il lui reste de l'énergie, false sinon
	 */
	public boolean consommeFun() {
		fun--;
		return super.consommeFun();
	}

}
