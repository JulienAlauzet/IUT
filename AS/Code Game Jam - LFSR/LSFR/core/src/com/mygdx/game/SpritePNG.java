package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SpritePNG extends MyGdxGame{
    private Sprite sprite;
    private Texture texture;

    private int  size_w, size_h;
    private int pos_x, pos_y;

    private SpriteBatch fond;

    public SpritePNG(String path, SpriteBatch fond, int pos_x, int pos_y, int size_w, int size_h){
        texture = new Texture(Gdx.files.internal(path));
        sprite = new Sprite(texture);

        this.fond = fond;

        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.size_h = size_h;
        this.size_w = size_w;

        sprite.setPosition(pos_x,pos_y);
        sprite.setSize(size_w,size_h);

    }

    public void display(){
        sprite.draw(fond);
    }

    public Sprite getSprite(){
        return sprite;
    }
}
