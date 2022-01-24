package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class College extends Actor {
    private final String name;
    private boolean isActive = true;
    private int health = 100;
    public static int damage = 10;

    private final Texture[] collegeBases;

    private float x = 0.0f;
    private float y = 0.0f;

    /**
     * Constructs a new College with the given name.
     * The college's flag texture will be loaded from the file `collegeFlag[Name].png`, where
     * [Name] is the supplied name.
     * @param name the name of the college.
     */
    public College(String name) {
        this.name = name;
        collegeBases = new Texture[] {
                new Texture(Gdx.files.internal("college-" + this.name + "-defeated.png")),
                new Texture(Gdx.files.internal("college-" + this.name + "-halfHealth.png")),
                new Texture(Gdx.files.internal("college-" + this.name + "-fullHealth.png")),
        };
    }

    /**
     * Get the college's name.
     * @return the college's name as a String.
     */
    public String getCollegeName() {
        return this.name;
    }

    /**
     * Perform an attack on the college dealing some damage.
     * @param damage the amount of damage to deal
     * @return whether the college remains an active threat.
     */
    public boolean attack(int damage) {
        this.health -= damage;
        isActive = this.health > 0;
        return isActive;
    }

    /**
     * Get the damage the college will do to the player (defence).
     * @return the damage to apply to the player.
     */
    public int defend() {
        return damage;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Batch batch, float parentAlpha) {
        if (isActive) batch.draw(collegeBases[Math.min(health / 33, 2)], x, y);
    }
}
