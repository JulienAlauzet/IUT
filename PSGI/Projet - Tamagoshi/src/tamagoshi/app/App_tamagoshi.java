package tamagoshi.app;

import tamagoshi.exceptions.NullExpressionRunTimeException;
import tamagoshi.tamagoshis.Tamagoshi;

public class App_tamagoshi {
	public static void main(String[] args) {
		Tamagoshi toto = null;
		try {
			toto = new Tamagoshi("toto");
		} catch (NullExpressionRunTimeException e) {
			e.printStackTrace();
		}
		if (toto != null) {
			toto.parle();
			System.out.println(toto.toString());
			System.out.println();
			toto.mange();
			System.out.println(toto.toString());
			while(toto.consommeEnergie()) {
				System.out.println(toto.toString());
			}
		}
	}
}
