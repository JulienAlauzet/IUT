package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.properties.*;

public class HeadMoveMenu extends MyGdxGame {

    private SpritePNG tete;

    private SpritePNG Z1;
    private SpritePNG Z2;
    private SpritePNG Z3;

    private int rot;
    private boolean tombe;
    private int tempo;
    private int selectZ;

    public HeadMoveMenu(SpriteBatch fond){
        tete = new SpritePNG(spriteProperties.teteOurs.PATH, fond, spriteProperties.teteOurs.POS_X, spriteProperties.teteOurs.POS_Y, spriteProperties.teteOurs.SIZE_X, spriteProperties.teteOurs.SIZE_Y);

        rot = 0;
        tombe = false;
        tempo = 0;
        selectZ = 0;

        Z1 = new SpritePNG("Z.png", fond, spriteProperties.teteOurs.POS_X_Z1,spriteProperties.teteOurs.POS_Y_Z1,spriteProperties.teteOurs.SIZE_X_Z1,spriteProperties.teteOurs.SIZE_Y_Z1);
        Z2 = new SpritePNG("Z.png", fond, spriteProperties.teteOurs.POS_X_Z2,spriteProperties.teteOurs.POS_Y_Z2,spriteProperties.teteOurs.SIZE_X_Z2,spriteProperties.teteOurs.SIZE_Y_Z2);
        Z3 = new SpritePNG("Z.png", fond, spriteProperties.teteOurs.POS_X_Z3,spriteProperties.teteOurs.POS_Y_Z3,spriteProperties.teteOurs.SIZE_X_Z3,spriteProperties.teteOurs.SIZE_Y_Z3);

    }

    public void animation(){
        if(tempo >= spriteProperties.teteOurs.TEMPO){
            if(rot >= spriteProperties.teteOurs.LIMIT_ROTA && !tombe){
                tombe = true;
                rot--;
            }else if(rot <= spriteProperties.teteOurs.LIMIT_ROTB && tombe){
                tombe = false;
                rot++;
            }else if(tombe){
                rot--;
            }else{
                rot++;
            }
            selectZ++;
            tempo = 0;
        }else{
            tempo++;
        }

        if(selectZ >= 4){
            selectZ = 0;
        }

        if(selectZ == 0){
            Z1.display();
        }else if(selectZ == 1){
            Z1.display();
            Z2.display();
        }else if(selectZ == 2){
            Z1.display();
            Z2.display();
            Z3.display();
        }else{

        }

        tete.getSprite().setRotation(rot);
        tete.display();
    }
}
