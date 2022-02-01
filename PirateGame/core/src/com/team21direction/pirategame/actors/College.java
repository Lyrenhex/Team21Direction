package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actions.FireCannon;
import com.team21direction.pirategame.actions.WhiteFlagRoutine;
import com.team21direction.pirategame.screens.MainScreen;

public class College extends GameActor {
    private String name;

    private final Texture[] collegeBases;
    public Sprite collegeBase;

    public boolean isWhiteFlag = false;

    /**
     * Constructs a new College with the given name.
     * The college's flag texture will be loaded from the file `collegeFlag[Name].png`, where
     * [Name] is the supplied name.
     * @param name the name of the college.
     */
    public College(MainScreen screen, String name) {
        super(screen);
        this.radius = 350;
        this.name = name;
        collegeBases = new Texture[] {
                new Texture(Gdx.files.internal("colleges/college-defeated-0.png")),
                new Texture(Gdx.files.internal("colleges/college-halfhealth.png")),
                new Texture(Gdx.files.internal("colleges/" + this.name + "-college-fullhealth.png")),
        };
        collegeBase = new Sprite(collegeBases[2]);
        this.addAction(new FireCannon());
    }

    /**
     * Get the college's name.
     * @return the college's name as a String.
     */
    public String getCollegeName() {
        return this.name;
    }

    public void setCollegeName(String name) {
        this.name = name;
        collegeBase = new Sprite(new Texture(Gdx.files.internal("colleges/" + this.name + "-college-fullhealth.png")));
    }

    /**
     * Perform an attack on the college dealing some damage.
     * @param damage the amount of damage to deal
     * @return whether the college remains an active threat.
     */
    @Override
    public boolean attack(int damage) {
        if (isActive()) {
            if (!super.attack(damage)) {
                collegeBase = new Sprite(collegeBases[0]);
                this.addAction(new WhiteFlagRoutine());
                isWhiteFlag = true;
            }
            else if (this.getHealth() < (this.getMaxHealth() / 2)) collegeBase = new Sprite(collegeBases[1]);
            else collegeBase = new Sprite(collegeBases[2]);
        } else if (isWhiteFlag) {
            isWhiteFlag = false;
            screen.gold += screen.goldPerCollege;
            this.clearActions();
            collegeBase = new Sprite(new Texture(Gdx.files.internal("colleges/college-defeated-0.png")));
        }
        return isActive();
    }

    /**
     * Draw the college on the screen.
     * This should be called once per frame by `Stage.draw()`.
     * @param batch the Batch to draw the college as part of for GPU optimisation.
     * @param parentAlpha the parent Actor's alpha value for alpha blending.
     */
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(collegeBase, getX() - (collegeBase.getWidth() / 2.0f), getY() - (collegeBase.getHeight() / 2.0f));
    }
}
