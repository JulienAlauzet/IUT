package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.properties.buttonProperties;

public class ClassicButton extends MyGdxGame{
    //private Stage stage;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    private String pathFond;

    private int pos_X, pos_Y, size_w, size_h;

    private ChangeListener function;

    public ClassicButton(int pos_X, int pos_Y, ChangeListener function){
        this.pathFond = buttonProperties.classic.PATH;

        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.size_w = buttonProperties.classic.SIZE_X;
        this.size_h = buttonProperties.classic.SIZE_Y;

        this.function = function;

        init();

    }


    public void init () {
        myTexture = new Texture(Gdx.files.internal(pathFond));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable); //Set the button up

        //stage = new Stage(new ScreenViewport()); //Set up a stage for the ui

        button.setSize(size_w,size_h);
        button.setPosition(pos_X,pos_Y);
        stage_UI.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage_UI); //Start taking input from the ui

        button.addListener(function);

        /*new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.print("Pressed:");
            }
        }*/



    }


    public void display () {
        stage_UI.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage_UI.draw(); //Draw the ui
    }

}
