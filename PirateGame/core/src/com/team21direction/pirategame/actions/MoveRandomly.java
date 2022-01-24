package com.team21direction.pirategame.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actors.Ship;

public class MoveRandomly extends Action {

    float totalTime = 0.0f;

    @Override
    public boolean act(float delta) {
        // TODO: improve movement logic
        totalTime += delta;
        actor.setPosition((int)(Math.random() * 800), (int)(Math.random() * 480));
        return !((Ship)actor).isActive(); // only 'complete' the action when the Ship is killed.s
    }
}
