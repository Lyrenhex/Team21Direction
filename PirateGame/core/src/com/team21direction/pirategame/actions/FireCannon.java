package com.team21direction.pirategame.actions;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actors.College;

public class FireCannon extends Action {
    float timeSinceLastCannon = 0.0f;

    @Override
    public boolean act(float delta) {
        College college = (College)actor;
        timeSinceLastCannon += delta;
        if (timeSinceLastCannon >= 2.0f + Math.random()) {
            college.screen.fireCannon(college, new Vector2(college.screen.player.getX() - college.getX(), college.screen.player.getY() - college.getY()).nor().scl(3.0f));
            timeSinceLastCannon = 0.0f;
        }
        return !college.isActive(); // only 'complete' the action when the College is defeated.
    }
}
