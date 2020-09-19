package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.properties.*;

public class StartButton extends MyGdxGame {
    //private Stage stage;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    private String pathFond;

    private int pos_X, pos_Y, size_w, size_h;

    public StartButton(String fond, int pos_X, int pos_Y){
        this.pathFond = fond;

        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.size_w = buttonProperties.start.SIZE_X;
        this.size_h = buttonProperties.start.SIZE_Y;

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
        stage_Start.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage_Start); //Start taking input from the ui

        button.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                MyGdxGame.setSTATE_GAME(1);
            }
        });



    }


    public void display () {
        stage_Start.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage_Start.draw(); //Draw the ui
    }

}
