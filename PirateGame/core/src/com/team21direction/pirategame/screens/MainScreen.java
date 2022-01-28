package com.team21direction.pirategame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.team21direction.pirategame.PirateGame;
import com.team21direction.pirategame.actors.College;
import com.team21direction.pirategame.actors.Ship;

public class MainScreen implements Screen {

    private Sprite sprite;
    private Batch batch;
    private Texture texture;

    private Game game;
    protected Stage stage;
    private Viewport viewport;
    protected Skin skin;
    protected TextureAtlas atlas;

    private OrthographicCamera camera;

    private College[] colleges;
    private Ship[] ships;
    private Ship player;

    public MainScreen(Game game) {
        this.game = game;
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));

        camera = new OrthographicCamera();

        batch = new SpriteBatch();

        viewport = new FitViewport(PirateGame.WORLD_WIDTH, PirateGame.WORLD_HEIGHT, camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        stage = new Stage(viewport, batch);

        colleges = new College[] {
                new College("Derwent"),
                new College("Langwith"),
                new College("Constantine"),
                new College("Halifax"),
        };
        ships = new Ship[PirateGame.SHIPS_PER_COLLEGE * colleges.length];
        for (int i = 0; i < colleges.length; i++) {
            colleges[i].setPosition((int)(Math.random() * PirateGame.WORLD_WIDTH), (int)(Math.random() * PirateGame.WORLD_HEIGHT));
            stage.addActor(colleges[i]);
            for (int j = 0; j < PirateGame.SHIPS_PER_COLLEGE; j++) {
                ships[i + j] = new Ship(colleges[i]);
                ships[i + j].setPosition((int)(Math.random() * PirateGame.WORLD_WIDTH), (int)(Math.random() * PirateGame.WORLD_HEIGHT));
                stage.addActor(ships[i + j]);
            }
        }
        player = new Ship(new College("Vanbrugh"));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        // fix for some PNG transparency quirks...
        batch.enableBlending();
        ScreenUtils.clear(0, 0.6f, 1, 1);
        Gdx.gl.glClear(GL20.GL_ALPHA_BITS);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        skin.dispose();
        atlas.dispose();
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float x = Gdx.input.getDeltaX();
        float y = Gdx.input.getDeltaY();

        camera.translate(-x,y);
        return true;
    }
    
}
