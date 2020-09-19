/*package com.mygdx.game;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ButtomAnimos extends MyGdxGame {
    private static Stage stage =  new Stage(new ScreenViewport()); //Set up a stage for the ui

    private ChangeListener F1 = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {

        }};

    private ChangeListener F2 = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {

        }};

    private ChangeListener F3 = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {

        }};

    private BigButton B1 = new BigButton("Upgrade.png","noUpgrade.png",200,400, F1, stage);
    private BigButton B2 = new BigButton("Upgrade.png","noUpgrade.png",200,300, F2, stage);
    private BigButton B3 = new BigButton("Upgrade.png","noUpgrade.png",200,200, F3, stage);

    public void display(){
        B1.display();
        B2.display();
        B3.display();
    }

    public void killStage(){
        //stage.clear();
    }
}
*/