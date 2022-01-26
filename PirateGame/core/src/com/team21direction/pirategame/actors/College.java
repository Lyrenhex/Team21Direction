package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class College extends GameActor {
    private final String name;

    private final Texture[] collegeBases;
    private Texture collegeBase;

    /**
     * Constructs a new College with the given name.
     * The college's flag texture will be loaded from the file `collegeFlag[Name].png`, where
     * [Name] is the supplied name.
     * @param name the name of the college.
     */
    public College(String name) {
        super();
        this.name = name;
        collegeBases = new Texture[] {
                new Texture(Gdx.files.internal("college-defeated-0.png")),
                new Texture(Gdx.files.internal("college-halfhealth.png")),
                new Texture(Gdx.files.internal(this.name + "-college-fullhealth.png")),
        };
        collegeBase = collegeBases[2];
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
    @Override
    public boolean attack(int damage) {
        if (!super.attack(damage)) collegeBase = collegeBases[0];
        else if (this.getHealth() > (this.getMaxHealth() / 2)) collegeBase = collegeBases[1];
        else collegeBase = collegeBases[2];
        return isActive();
    }

    /**
     * Draw the college on the screen.
     * This should be called once per frame by `Stage.draw()`.
     * @param batch the Batch to draw the college as part of for GPU optimisation.
     * @param parentAlpha the parent Actor's alpha value for alpha blending.
     */
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(collegeBase, getX(), getY());
    }
}
