package tamagoshi.app;

import tamagoshi.jeu.TamaGame;

public class App_tamagame {
	public static void main(String[] args) {
		TamaGame partie = new TamaGame();
		partie.play();
		System.out.println(partie.resultat());
	}
}
