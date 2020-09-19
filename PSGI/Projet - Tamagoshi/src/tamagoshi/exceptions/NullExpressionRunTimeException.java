package tamagoshi.exceptions;

/**
 * Exception générée lors d'une mauvaise utilisation de la méthode {@link tamagoshi.tamagoshis.Tamagoshi#setName}.
 * 
 * @author alauzetj
 * @see tamagoshi.tamagoshis.Tamagoshi
 */

public class NullExpressionRunTimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2229030063102057295L;

	/**
	 * constructeur pour l'exception
	 * @param message le message d'erreur
	 */
	public NullExpressionRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
