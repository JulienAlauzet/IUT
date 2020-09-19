package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	public static SpriteBatch batch;
	private Texture img_acceuil;
	private Texture img_UI;
	private Texture animosPage, biomePage;


	private StartButton startButton;
	private SpritePNG gland;
	private HeadMoveMenu ours;

	private SpritePNG glandCountIcon;

	private BigButton button1;
	private BigButton button2;

	private static int STATE_GAME;

	private ChangeListener plus, moins;

	public static Stage stage_Start;
	public static Stage stage_UI;

	private BitmapFont font;
	public static int nbGland = 0;

	private boolean displayMap = true;

	private double tempo = 0;



	@Override
	public void create () {
		batch = new SpriteBatch();
		img_acceuil = new Texture("acceuil.png");
		img_UI = new Texture("UI.png");

		//PAGE
		animosPage = new Texture("page_animos.png");
		biomePage = new Texture("page_biome.png");

		stage_Start = new Stage(new ScreenViewport()); //Set up a stage for the ui


		ours = new HeadMoveMenu(batch);


		plus =  new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.print("Pressed:");
				MyGdxGame.nbGland++;
				displayMap = true;
			}};

		moins =  new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.print("Pressed:");
				MyGdxGame.nbGland--;
				displayMap = false;

			}};

		startButton = new StartButton("Start.png", 300, 20);

		font = new BitmapFont();

		glandCountIcon = new SpritePNG("Gland.png", batch, 375,460, 20,20);



		STATE_GAME = 0;
	}

	@Override
	public void render () {
		switch(STATE_GAME){
			case 0:	//MENU
				Gdx.gl.glClearColor(1, 1, 1, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

				batch.begin();

				batch.draw(img_acceuil, 0, 0, 800, 480);
				ours.animation();

				batch.end();

				startButton.display();

				break;

			case 1:	//CREATE UI
				stage_Start.dispose();
				stage_UI = new Stage(new ScreenViewport()); //Set up a stage for the ui
				button1 = new BigButton("animos.png",60,5, plus);
				button2 = new BigButton("biome.png",500,5, moins);

				initZone();



				STATE_GAME = 2;
				break;

			case 2:	//DISPLAY UI
				batch.begin();
				batch.draw(img_acceuil, 0, 0, 800, 480);


				if(displayMap){	//MENU ANIMOS
					//FOND
					batch.draw(animosPage, 10, 100, 780, 340);

					//PRIX
					AffAnimosMenu.affPrix();
					AffAnimosMenu.affNB();
					AffAnimosMenu.affStat();
					//AffAnimosMenu.affButton();

				}else{
					batch.draw(biomePage, 10, 100, 780, 340);
					AffZone.display();
				}

				batch.draw(img_UI, 0, 0, 800, 480);

				font.draw(batch, String.valueOf(Zone.getZoneById(4).getSoldeZone()), 395, 475);
				glandCountIcon.display();

				batch.end();

				button1.display();

				break;

		}

		animalsBG();

	}


	@Override
	public void dispose () {
		batch.dispose();
		img_acceuil.dispose();
	}

	public static int getSTATE_GAME(){
		return STATE_GAME;
	}

	public static void setSTATE_GAME(int value){
		STATE_GAME = value;
	}

	public void initZone(){

		Zone z;
		for (int i = 0 ; i < 9 ; i++){
			z = new Zone ();
		}


		for(int i = 0;i<9;i++){
			Zone.getZoneById(i).activer();
		}




	}

	public void animalsBG(){
        for(int i = 0;i<Animal.getNbAnimaux();i++){
            if(tempo <= 0){
                tempo = 500 * Animal.getTabDuree()[Animal.getAnimalById(i).getType()]*Animal.getAnimalById(i).getZone();
                Animal.getAnimalById(i).comportement();
                System.out.print("move:");
            }else{
                tempo--;
            }
        }
    }
}
