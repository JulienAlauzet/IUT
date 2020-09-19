package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AffAnimosMenu extends MyGdxGame{

    private static PrixText prix1 = new PrixText("Prix :" + Animal.getCouts(0),batch,370,350);
    private static PrixText prix2 = new PrixText("Prix :" + Animal.getCouts(1),batch,370,255);
    private static PrixText prix3 = new PrixText("Prix :" + Animal.getCouts(2),batch,370,133);

    private static PrixText nb1 = new PrixText(String.valueOf(Animal.getNbEcureuil()),batch,105,338);
    private static PrixText nb2 = new PrixText(String.valueOf(Animal.getNbOiseau()),batch,105,239);
    private static PrixText nb3 = new PrixText(String.valueOf(Animal.getNbOurs()),batch,105,122);

    private static PrixText stat1 = new PrixText(Animal.toStringAnimal(0),batch,512,406);
    private static PrixText stat2 = new PrixText(Animal.toStringAnimal(1),batch,512,310);
    private static PrixText stat3 = new PrixText(Animal.toStringAnimal(2),batch,512,188);



    //private static ButtomAnimos B = new ButtomAnimos();


    public static void affPrix(){
        prix1.display();
        prix2.display();
        prix3.display();
    }

    public static void affNB(){
        nb1.display();
        nb2.display();
        nb3.display();
    }

    public static void affStat(){
        stat1.display();
        stat2.display();
        stat3.display();
    }

    public static void affButton(){
        //B.display();
    }

    public static void clearButton(){
       // B.killStage();
    }
}
