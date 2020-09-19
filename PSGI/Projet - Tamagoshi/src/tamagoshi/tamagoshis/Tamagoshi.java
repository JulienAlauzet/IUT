package tamagoshi.tamagoshis;
/**
 * La classe Tamagoshi modélise un Tamagoshi.<br>
 * Un Tamagoshi est un petit être dont il faut s'occuper afin qu'il ne déperrisse pas<br>
 * Il dispose d'un certain capital énergie qui doit être maintenu au-dessus d'un certain seuil, en le nourrissant, sans quoi il est affamé.<br>
 * Il dispose d'un certain capital fun qui doit être maintenu au dessus d'un certain seuil, en jouant avec lui, sans quoi il s'ennuie.
 * 
 * @see NullExpressionRunTimeException
 * @see TamaGame
 * @See Random
 * @author alauzetj
 */

import java.util.Random;

import tamagoshi.exceptions.NullExpressionRunTimeException;

public class Tamagoshi {

	// Déclaration des attributs (Exo1)

	/**
	 * L'âge du Tamagoshi. Il est intitialisé à 0 et s'auto-incrémente
	 */
	private int age;
	/**
	 * Le capital max en énergie du Tamagoshi. Il est initialisé, alétoirement entre 5 et 9
	 */
	private int maxEnergy;
	/**
	 * Le capital de départ en énergie. Il est initialisé entre 3 et 7 (ou maxEnergy)
	 */
	protected int energy;
	/**
	 * Le capital max en fun du Tamagoshi. Il est initialisé, alétoirement entre 5 et 9
	 */
	private int maxFun;
	/**
	 * Le capital de départ en fun. Il est initialisé entre 3 et 7 (ou maxFun)
	 */
	protected int fun;
	/**
	 * Le nom du Tamagoshi, une simple chaîne de caractères
	 */
	private String name;

	/**
	 * La durée de vie du Tamagoshi, partagée par toutes les instances de la classe Tamagoshi
	 */
	private static int lifeTime = 10;
	
	/**
	 * Une liste prédéfinie de noms de Tamagoshis, partagée par toutes les instances de la classe Tamagoshi
	 */
	private static String[] listeNoms = {"Hulk", "Superman", "Batman", "Cartman", "Ragnar", "Jinx", "Calvet", "Garcia", "Mickey"};

	/**
	 * Un objet de la classe Random afin de faire des tirages aléatoires
	 */
	private Random rand;



	// Génération du constructeur (Exo2)

	/**
	 * Constructeur pour la classe Tamagoshi.<br>
	 * Crée un tamagoshi avec des valeurs aléatoires pour énergie et fun et avec le nom donné en paramètre.
	 * 
	 * @param name le nom du Tamagoshi
	 * @throws NullExpressionRunTimeException si le nom donné est nul
	 */
	public Tamagoshi(String name) throws NullExpressionRunTimeException {
		super();
		setName(name);
		age = 0;
		rand = new Random();
		maxEnergy = rand.nextInt(9 - 5 + 1) + 5;
		energy = rand.nextInt( ((maxEnergy > 7) ? 7 : maxEnergy) - 3 + 1) + 3;	
		maxFun = rand.nextInt(9 - 5 + 1) + 5;
		fun = rand.nextInt( ((maxFun > 7) ? 7 : maxFun) - 3 + 1) + 3;	
	}	
	
	/**
	 * Constructeur pour la classe Tamagoshi.<br>
	 * Crée un tamagoshi avec des valeurs aléatoires pour énergie et fun et avec un nom tiré aléatoirement parmi une liste de noms privée.
	 * 
	 * @throws NullExpressionRunTimeException si le nom donné est nul
	 */
	public Tamagoshi() throws NullExpressionRunTimeException {
		super();
		age = 0;
		rand = new Random();
		maxEnergy = rand.nextInt(9 - 5 + 1) + 5;
		energy = rand.nextInt( ((maxEnergy > 7) ? 7 : maxEnergy) - 3 + 1) + 3;	
		maxFun = rand.nextInt(9 - 5 + 1) + 5;
		fun = rand.nextInt( ((maxFun > 7) ? 7 : maxFun) - 3 + 1) + 3;	
		setName(listeNoms[rand.nextInt(listeNoms.length - 1 - 0 + 1) + 0]);
	}
	

	// toString afin de vérifier mes résultats
	@Override
	/**
	 * crée une représentation sous forme de string de l'objet Tamagoshi
	 * @return une chaîne de caractères
	 */
	public String toString() {
		return "Tamagoshi [name=" + name + ", age=" + age + ", maxEnergy=" + maxEnergy + ", energy=" + energy + ", maxFun=" + maxFun + ", fun=" + fun + "]";
	}

	// Exo3

	/**
	 * Fait parler le Tamagoshi pour annoncer son état.<br>
	 * Il peut être en bonne forme si son énergie et son fun sont respectivement maintenus au-dessus de 4.<br>
	 * Dans le cas contraire, il peut-être affamé et/ou ennuyé.
	 * @return un booléen : true si le Tamagoshi est heureux, false sinon
	 */
	public boolean parle() {
		if (energy <= 4 && fun <=4)
			System.out.println(name + " : \"je suis affamé et je m'ennuie à mourrir !\"");
		else if (energy > 4 && fun > 4)
			System.out.println(name + " : \"tout va bien !\"");
		else if (energy > 4)
			System.out.println(name + " : \"je m'ennuie à mourrir !\"");
		else
			System.out.println(name + " : \"je suis affamé !\"");
		return (energy > 4 && fun > 4);
	}

	// Exo4

	/**
	 * Fait manger le Tamagoshi pour augmenter son énergie.<br>
	 * S'il n'est pas déjà au maximum, son capital énergie est incrémenté d'une valeur comprise entre 1 et 3.<br>
	 * Sinon il montre son mécontentement
	 * @return un booléen : true si le Tamagoshi a bien mangé, false sinon
	 */
	public boolean mange() {
		if (energy < maxEnergy) {
			energy += rand.nextInt( ((maxEnergy - energy < 3) ? maxEnergy - energy : 3) - 1 + 1 ) + 1;
			System.out.println("\n" + name + " : \"Miam c'et bon !\"");
		} 
		else {
			System.out.println("\n" + name + " : \"laisse-moi tranqille, j'ai le ventre plein !!\"");
			return false;
		}
		return true;
	}

	// Exo 15

	/**
	 * Fait jouer le Tamagoshi pour augmenter son fun.<br>
	 * S'il n'est pas déjà au maximum, son capital fun est incrémenté d'une valeur comprise entre 1 et 3.<br>
	 * Sinon il montre son mécontentement
	 * @return un booléen : true si le Tamagoshi a bien joué, false sinon
	 */
	public boolean joue() {
		if (fun < maxFun) {
			fun += rand.nextInt( ((maxFun - fun < 3) ? maxFun - fun : 3) - 1 + 1 ) + 1;
			System.out.println("\n" + name + " : \"On se marre !\"");
		} 
		else {
			System.out.println("\n" + name + " : \"laisse-moi tranqille, je bouquine !!\"");
			return false;
		}
		return true;
	}

	// Exo 5

	/**
	 * Fait consommé un point d'énergie au Tamagoshi<br>
	 * Si son capital atteint 0, il exprime un dernier râle
	 * @return un booléen : true s'il lui reste de l'énergie, false sinon
	 */
	public boolean consommeEnergie() {
		energy --;
		if (energy <= 0) {
			System.out.println(name + " : \"je suis KO : Arrrrggh !\"");
			return false;
		}
		return true;
	}

	// Exo 15

	/**
	 * Fait consommé un point de fun au Tamagoshi<br>
	 * Si son capital atteint 0, il exprime un dernier râle
	 * @return un booléen : true s'il lui reste du fun, false sinon
	 */
	public boolean consommeFun() {
		fun --;
		if (fun <= 0) {
			System.out.println(name + " : \"snif : je fais une dépression, ciao!\"");
			return false;
		}
		return true;
	}

	/**
	 * Fait vieillir le Tamagoshi<br>
	 * Son age est incrémenté de 1.
	 * @return un booléen : true s'il n'a pas atteint l'âge limite, false sinon
	 */
	public boolean vieillir() {
		age ++;
		if (age >= lifeTime)
			return false;
		return true;
	}

	/**
	 * Indique si le Tamagoshi a encore de l'énergie et du fun<br>
	 * Permet de déterminer si le Tamagoshi a survécu à une partie
	 * @return un booléen : true si le Tamagoshi dispose encore de fun et d'énergie, false sinon
	 */
	public boolean enForme() {
		return (energy > 0 && fun > 0);
	}

	/**
	 * Récupère le nom du Tamagoshi<br>
	 * Utilisé lors de l'affichage console pour les choix utilisateurs dans la méthode {@link tamagoshi.jeu.TamaGame#play()}.
	 * @return une chaine de caractères
	 */
	public String getName() {
		return name;
	}

	/**
	 * Récupère la durée de vie du Tamagoshi<br>
	 * Utilisé lors du calcul du score de fin de partie.
	 * @return un entier
	 */
	public static int getLifeTime() {
		return lifeTime;
	}

	/**
	 * Récupère l'âge du Tamagoshi<br>
	 * Utilisé lors du calcul du score de fin de partie.
	 * @return un entier
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Modifie le nom du Tamagoshi
	 * @param name une chaîne de caractères non nulle
	 * @throws NullExpressionRunTimeException si name est nulle
	 */
	public void setName(String name) throws NullExpressionRunTimeException {
		if (name.equals(""))
			throw (new NullExpressionRunTimeException("erreur : la saisie pour le nom du tamagoshi ne peut être nulle"));
		this.name = name;
	}	
	
	

}
