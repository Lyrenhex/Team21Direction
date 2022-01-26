package com.team21direction.pirategame.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actors.Ship;

public class MoveRandomly extends Action {

    float totalTime = 0.0f;

    /**
     * Move each NPC ship randomly every frame.
     * @param delta the time since the last frame.
     * @return whether the ship is active (hence, if false, the action should cease executing on that ship).
     */
    @Override
    public boolean act(float delta) {
        // TODO: improve movement logic
        totalTime += delta;
        ((Ship)actor).move((int)(Math.random() * 5), (int)(Math.random() * 5));
        return !((Ship)actor).isActive(); // only 'complete' the action when the Ship is killed.
    }
}
