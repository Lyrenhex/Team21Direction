package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.team21direction.pirategame.PirateGame;
import com.team21direction.pirategame.actions.CannonballAction;

public class Cannonball extends GameActor {
    public final Vector2 direction = new Vector2();

    private final Texture texture = new Texture(Gdx.files.internal("cannonball.png"));
    private final Sprite sprite = new Sprite(texture);

    public boolean live = true;

    public PirateGame game;

    public Cannonball(float x, float y, Vector2 direction, PirateGame game) {
        this.setX(x);
        this.setY(y);
        this.game = game;
        this.direction.set(direction);
        this.addAction(new CannonballAction());
    }

    /**
     * Draw the cannonball on the screen.
     * This should be called once per frame by `Stage.draw()`.
     * @param batch the Batch to draw the cannonball as part of for GPU optimisation.
     * @param parentAlpha the parent Actor's alpha value for alpha blending.
     */
    public void draw(Batch batch, float parentAlpha) {
        if (live) batch.draw(sprite, getX() - (sprite.getWidth() / 2), getY() - (sprite.getHeight() / 2));
    }
}
