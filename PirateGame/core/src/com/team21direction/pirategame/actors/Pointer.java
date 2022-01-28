package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.team21direction.pirategame.actions.MoveRandomly;

import java.util.HashMap;

public class Pointer extends GameActor {

    private Texture texture = new Texture(Gdx.files.internal("cannonball.png"));

    public void draw(Batch batch, float parentAlpha) {
        if (isActive()) {
            batch.draw(texture, getX() - (texture.getWidth() / 2), getY() - (texture.getHeight() / 2));
        }
    }
}
