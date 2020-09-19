package tamagoshi.jeu;

/**
 * La classe TamaGame modélise une partie de Tamagoshis.<br>
 * L'utilisateur crée des Tamagoshis, les nomme et s'occupe ensuite d'eux jusqu'à ce qu'ils meurrent tous de faim, d'ennui, ou de vieillesse<br>
 * A la fin de la partie, il visualise un bilan qui lui indique son score final
 * 
 * @see NullExpressionRunTimeException
 * @see NotNaturalRunTimeException
 * @See Tamagoshis
 * @author alauzetj
 */

import java.util.ArrayList;
import java.util.Random;

import tamagoshi.exceptions.NotNaturalRunTimeException;
import tamagoshi.exceptions.NullExpressionRunTimeException;
import tamagoshi.tamagoshis.GrosJoueur;
import tamagoshi.tamagoshis.GrosMangeur;
import tamagoshi.tamagoshis.Tamagoshi;
import tamagoshi.util.Utilisateur;

public class TamaGame {

	// Définition des attributs (Exo 8)

	/**
	 * Liste des Tamagoshis intitialisés au début de la partie
	 */
	private static ArrayList<Tamagoshi> tamagoshisDepart;
	/**
	 * Liste des Tamagoshis encore vivant durant la partie
	 */
	private static ArrayList<Tamagoshi> tamagoshisEnCours;

	// Constructeur (Exo 8)

	/**
	 * Constructeur pour la classe TamaGame
	 * Initialise les deux listes de Tamagoshis
	 */
	public TamaGame() {
		super();
		tamagoshisDepart = new ArrayList<Tamagoshi>();
		tamagoshisEnCours = new ArrayList<Tamagoshi>();
	}

	// toString pour les tests

	@Override
	/**
	 * crée une représentation sous forme de string de l'objet TamaGame
	 * @return une chaîne de caractères
	 */
	public String toString() {
		String maSortie = "Tamagoshis de départ :\n"
				+ tamagoshisDepart.toString()
				+ "\n\nTamagoshis en cours :\n"
				+ tamagoshisEnCours.toString();
		return maSortie;
	}

	/**
	 * Indique si la partie est jouable<br>
	 * Si l'utilisateur s'est trompé dans la création de Tamagoshis, il est inutile de jouer la partie
	 * @return un booléen : true si la liste des Tamagoshis de départ contient un ou des élements, false sinon
	 */
	private boolean playable() {
		return tamagoshisDepart.size() > 0;
	}

	// Exo 9

	@SuppressWarnings("unchecked")
	/**
	 * Initialise la partie<br>
	 * L'utilisateur choisit le nombre de Tamagoshis avec lequel il souhaite jouer et la méthode @see setTamagoshisDepart remplit la liste des Tamagoshis de départ en conséquence.
	 */
	private void initialisation() {
		System.out.println("Entrez le nombre de tamagoshis désiré :");
		String nbTama = Utilisateur.saisieClavier();
		System.out.println("Souhaitez-vous les nommer vous-même ou bien leur attribuer des noms aléatoire ?");
		System.out.println("(1)Aléatoire\t\t(2)Personnaliser");
		System.out.println("entrez votre choix :\t");
		String choixAleatoire = Utilisateur.saisieClavier();
		try {
			setTamagoshisDepart (nbTama, choixAleatoire);
		} catch (NotNaturalRunTimeException e) {
			e.printStackTrace();
		}
		tamagoshisEnCours = (ArrayList<Tamagoshi>)tamagoshisDepart.clone();
	}

	/**
	 * Crée le nombre de Tamagoshis choisi et les ajoute à la liste des Tamagoshis de départt
	 * @param nbTama une chaîne de caractères devant être un entier naturel 
	 * @param choixAleatoire une chaine de caractere devant etre 1 ou 2
	 * @throws NotNaturalRunTimeException si la chaîne de caractère n'est pas un entier naturel
	 */
	private void setTamagoshisDepart(String nbTama, String choixAleatoire) throws NotNaturalRunTimeException {
		int nbTamaInt = - 1;
		try {
			nbTamaInt = Integer.parseInt(nbTama);
		} catch (NumberFormatException e) {
			throw (new NotNaturalRunTimeException("erreur : le nombre de tamagoshis désiré doit être un entier naturel, votre saisie : " + nbTama));
		}

		int choixAleatoireInt = - 1;
		try {
			choixAleatoireInt = Integer.parseInt(choixAleatoire);
		} catch (NumberFormatException e) {
			throw (new NotNaturalRunTimeException("erreur : le choix pour le nommage doit être un entier, votre saisie : " + choixAleatoire));
		}
		if (nbTamaInt < 1)
			throw (new NotNaturalRunTimeException("erreur : le nombre de tamagoshis désiré doit être un entier naturel, votre saisie : " + nbTamaInt));
		if (choixAleatoireInt != 1 && choixAleatoireInt != 2)
			throw (new NotNaturalRunTimeException("erreur : le nombre de tamagoshis désiré doit être 1 ou 2, votre saisie : " + choixAleatoireInt));

		for (int i = 1 ; i <= nbTamaInt ; i++) {
			Tamagoshi tama = null;
			Random rand = new Random();
			boolean typeTama = rand.nextBoolean();
			if (choixAleatoireInt == 2) {
				System.out.println("Entrez le nom du tamagoshi numéro " + i + " :");
				String nomTama = Utilisateur.saisieClavier();
				try {
					if (typeTama)
						tama = new GrosMangeur(nomTama);
					else
						tama = new GrosJoueur(nomTama);
				} catch (NullExpressionRunTimeException e) {
					System.out.println("--erreur : la saisie pour le nom du tamagoshi ne peut être nulle--\n");
					i--;
				}
			} else {
				try {
					if (typeTama)
						tama = new GrosMangeur();
					else
						tama = new GrosJoueur();
				} catch (NullExpressionRunTimeException e) {
					System.out.println("--erreur : le nom attribué tamagoshi ne peut être nulle--\n");
					i--;
				}
			}
			if (tama != null)
				tamagoshisDepart.add(tama);
		}
	}



	// Exo 10

	/**
	 * Exécute le déroulement de la partie, si elle est jouable, et ce à l'aide d'une boucle répétée, tant que la partie n'est pas finie<br>
	 * Déroulement d'un tour :<br>
	 * - les tamagoshis parleront<br>
	 * - puis l'utilisateur pourra leur donner à manger<br>
	 * - puis les tamagoshis consommeront de l'énergie et vieillirons.<br>
	 * - puis les tamagoshis ayant une énergie inférieure ou égale à zéro ou ayant rejoint leur âge limite sont retirés.<br>
	 * - fin du tour de jeu.
	 */
	public void play() {
		initialisation();
		if (playable()) {
			for (int nCycle = 1; enCours(); nCycle++) {
				System.out.println("\n----------Cycle n°" + nCycle + "----------");
				for (Tamagoshi tamagoshi : tamagoshisEnCours) {
					System.out.println();
					tamagoshi.parle();
				}

				int tamaANourrir;
				for (tamaANourrir = -1; tamaANourrir > tamagoshisEnCours.size() || tamaANourrir < 1; ) {
					System.out.println("\nNourrir quel tamagoshi ?");
					for (Tamagoshi tamagoshi : tamagoshisEnCours) {
						System.out.print("(" + (tamagoshisEnCours.indexOf(tamagoshi) + 1) + ")" + tamagoshi.getName() + "\t\t");
					}
					System.out.print("\nentrez votre choix :\t");
					tamaANourrir = Integer.parseInt(Utilisateur.saisieClavier());
					if (tamaANourrir > tamagoshisEnCours.size()  || tamaANourrir < 1)
						System.out.println("\n--erreur--\nSaisir une valeur correcte svp ! (Entre 1 et " + tamagoshisEnCours.size() + "; votre saisie : " + tamaANourrir + ")");
				}
				tamagoshisEnCours.get(tamaANourrir - 1).mange();

				int tamaAAmuser;
				for (tamaAAmuser = -1; tamaAAmuser > tamagoshisEnCours.size() || tamaAAmuser < 1; ) {
					System.out.println("\nJouer avec quel tamagoshi ?");
					for (Tamagoshi tamagoshi : tamagoshisEnCours) {
						System.out.print("(" + (tamagoshisEnCours.indexOf(tamagoshi) + 1) + ")" + tamagoshi.getName() + "\t\t");
					}
					System.out.print("\nentrez votre choix :\t");
					tamaAAmuser = Integer.parseInt(Utilisateur.saisieClavier());
					if (tamaAAmuser > tamagoshisEnCours.size()  || tamaAAmuser < 1)
						System.out.println("\n--erreur--\nSaisir une valeur correcte svp ! (Entre 1 et " + tamagoshisEnCours.size() + "; votre saisie : " + tamaAAmuser + ")");
				}
				tamagoshisEnCours.get(tamaAAmuser - 1).joue();

				tamagoshisEnCours.removeIf(n -> !n.consommeEnergie() || !n.consommeFun() || !n.vieillir());
			}
			System.out.println("\n---------- fin de partie !! ----------");
		}
	}

	/**
	 * Indique si la partie est en cours
	 * @return un bolléen : true si la liste des Tamagoshis en cours n'est pas vide, false sinon
	 */
	private boolean enCours() {
		return !(tamagoshisEnCours.isEmpty());
	}

	// Exo 11

	/**
	 * Calcule le score de la partie<br>
	 * Il se calcul comme étant le ratio, ramené en pourcentage, entre la somme des âges atteints par les tamagoshis et la somme de leurs durées de vie
	 * @return un entier
	 */
	private int score() {
		int score = 0;
		for (Tamagoshi tamagoshi : tamagoshisDepart) {
			score += tamagoshi.getAge();
		}
		return score * 100 / (tamagoshisDepart.size() * Tamagoshi.getLifeTime());
	}

	// Exo 12

	/**
	 * Affiche un bilan de la partie sur la console<br>
	 * Liste de létat des Tamagoshis et score
	 * @return une chaine de caractères
	 */
	public String resultat() {
		if (playable()) {
			String maSortie = "\n----------bilan----------";
			for (Tamagoshi tamagoshi : tamagoshisDepart) {
				maSortie += "\n" + tamagoshi.getName() + " qui était un " + tamagoshi.getClass().getSimpleName() +(tamagoshi.enForme() ? " a survécu et vous remercie :)" : " n'est pas arrivé jusqu'au bout et ne vous félicite pas :(");
			}
			maSortie += "\n\nscore obtenu : " + score() + "%";
			return maSortie;
		}
		else return "";
	}

}
