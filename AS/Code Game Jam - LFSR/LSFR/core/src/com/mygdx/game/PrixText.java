package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.properties.*;

public class PrixText extends MyGdxGame {

    private String text;
    private BitmapFont font;

    private int pos_x, pos_y;

    private int scale;

    private SpriteBatch fond;

    public PrixText(String text, SpriteBatch fond, int pos_x, int pos_y){
        font = new BitmapFont();
        this.fond = fond;

        this.pos_x = pos_x;
        this.pos_y = pos_y;

        this.text = text;

        font.setColor(spriteProperties.prixText.COLOR);
    }

    public void display(){
        font.draw(this.fond,text,pos_x,pos_y);
    }
}
