package tamagoshi.exceptions;

/**
 * Exception générée lors d'une mauvaise saisie de l'utilisateur.<br>
 * Certains cas nécessitent l'emploi d'un entier naturel
 * 
 * @author alauzetj
 * @see tamagoshi.jeu.TamaGame
 */

public class NotNaturalRunTimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942617037214744588L;

	/**
	 * constructeur pour l'expression
	 * @param message le message d'erreur
	 */
	public NotNaturalRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
