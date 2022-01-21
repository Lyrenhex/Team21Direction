package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ship extends Actor {
    private int health = 100;
    public static int damage = 10;
    public College parentCollege; // The College this ship is allied with.

    private final Texture ship;

    /**
     * Construct a new Ship which is a member of the supplied parentCollege.
     * @param parentCollege the College which the ship is allied to.
     */
    public Ship(College parentCollege) {
        this.parentCollege = parentCollege;
        if (parentCollege == null)
            ship = new Texture(Gdx.files.internal("ship.png"));
        else
            ship = new Texture(Gdx.files.internal("ship" + parentCollege.getCollegeName() + ".png"));
    }

    public Ship() {
        this(null);
    }

    public boolean attack(int damage) {
        this.health -= damage;
        return this.health <= 0;
    }

    public int defend() {
        return damage;
    }

    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.draw(ship, 0, 0);
    }
}
