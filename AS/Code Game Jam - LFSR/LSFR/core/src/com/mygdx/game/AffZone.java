package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class AffZone extends MyGdxGame {

    private static Texture classic = new Texture("zone_normal.png");
    private static Texture snow = new Texture("zone_neige.png");
    private static Texture savane = new Texture("zone_savane.png");
    private static Texture marais = new Texture("zone_mare.png");
    private static Texture depot = new Texture("zone_base.png");
    private static Texture lock = new Texture("zone_lock.png");

    private static int[] tab = {0,5,5,5,4,5,5,5,5};
    private static float[] pos_x = {175,380,585,175,380,585,175,380,585};
    private static float[] pos_y = {330,330,330,220,220,220,110,110,110};

    private static final int SIZE_X = 195;
    private static final int SIZE_Y = 100;

    public static void display(){
        for(int i=0;i<tab.length;i++){
            hubAff(tab[i], i);
        }
    }

    public static void hubAff(int x, int i){
        switch (x){
            case 0:
                batch.draw(classic,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;
            case 1:
                batch.draw(savane,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;
            case 2:
                batch.draw(marais,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;
            case 3:
                batch.draw(snow,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;
            case 4:
                batch.draw(depot,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;
            case 5:
                batch.draw(lock,pos_x[i],pos_y[i],SIZE_X,SIZE_Y);
                break;


        }
    }

    public static int[] getTab() {
        return tab;
    }
}
