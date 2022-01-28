package com.team21direction.pirategame.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.actors.Cannonball;
import com.team21direction.pirategame.actors.GameActor;

public class CannonballAction extends Action {
    float liveTime = 0.0f;

    /**
     * Move the cannonball each frame for as long as it's alive.
     * @param delta the time since the last frame.
     * @return whether the cannonball is active (hence, if false, the action should cease executing on that ship).
     */
    @Override
    public boolean act(float delta) {
        liveTime += delta;
        Cannonball cannonball = (Cannonball) actor;
        float deltaX = (int)(cannonball.direction.x * 5);
        float deltaY = (int)(cannonball.direction.y * 5);
        cannonball.move(deltaX, deltaY);
        if (liveTime >= 5.0f) cannonball.live = false;
        GameActor victim = cannonball.game.mainScreen.getCollision(cannonball.getX(), cannonball.getY());
        if (victim != null) {
            victim.attack(cannonball.getDamage());
            cannonball.live = false;
        }
        return !(cannonball.live); // only 'complete' the action when the cannonball expires / hits something.
    }
}
