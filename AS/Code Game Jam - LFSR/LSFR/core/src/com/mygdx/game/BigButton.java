package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.properties.buttonProperties;

public class BigButton extends MyGdxGame{
    private Stage stageMeth;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    private String pathFond;
    private String pathFondD;

    private int pos_X, pos_Y, size_w, size_h;

    private ChangeListener function;

    private boolean active = true;
    private boolean activeMem = true;

    public BigButton(String path, int pos_X, int pos_Y, ChangeListener function/*, Stage stage*/){
        this.pathFond = path;

        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.size_w = buttonProperties.big.SIZE_X;
        this.size_h = buttonProperties.big.SIZE_Y;

        this.function = function;

        this.pathFondD = pathFond;

        this.stageMeth = stage_UI;

        init();

    }

    public BigButton(String path, String pathDisable, int pos_X, int pos_Y, ChangeListener function, Stage stage){
        this.pathFond = path;

        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.size_w = buttonProperties.big.SIZE_X;
        this.size_h = buttonProperties.big.SIZE_Y;

        this.function = function;

        this.pathFondD = pathDisable;

        this.stageMeth = stage;
        init();

    }


    public void init () {

        if(active){
            myTexture = new Texture(Gdx.files.internal(pathFond));
        }else{
            myTexture = new Texture(Gdx.files.internal(pathFondD));
        }

        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable); //Set the button up

        //stage = new Stage(new ScreenViewport()); //Set up a stage for the ui

        button.setSize(size_w,size_h);
        button.setPosition(pos_X,pos_Y);
        stageMeth.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stageMeth); //Start taking input from the ui

        if(active) {
            button.addListener(function);
        }else{
            //RIEN
        }
        /*new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.print("Pressed:");
            }
        }*/



    }


    public void display () {
       /* if(activeMem != active){
            activeMem = active;
            init();
        }*/
        stage_UI.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage_UI.draw(); //Draw the ui
    }

    public void disabled(){
        active = false;
    }

    public void enabled(){
        active = true;
    }


}
