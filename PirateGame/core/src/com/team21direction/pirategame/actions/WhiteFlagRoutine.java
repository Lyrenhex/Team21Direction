package com.team21direction.pirategame.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actors.College;
import com.team21direction.pirategame.actors.Ship;

import java.util.Random;

public class WhiteFlagRoutine extends Action {
    float totalAnimationDuration = 0.0f;
    int animState = 0;

    @Override
    public boolean act(float delta) {
        College college = (College)actor;
        totalAnimationDuration += delta;
        animState = (int)(totalAnimationDuration / 0.5f);
        if (animState > 3) {
            animState = 3;
        }
        college.collegeBase = new Sprite(new Texture(Gdx.files.internal("colleges/college-defeated-" + animState + ".png")));
        if (totalAnimationDuration >= 10.0f) {
            // mercy; the College joins the player's College.
            college.setCollegeName(college.screen.player.parentCollege.getCollegeName());
        }
        return totalAnimationDuration >= 10.0f; // only 'complete' the action when the Ship is killed.
    }
}
