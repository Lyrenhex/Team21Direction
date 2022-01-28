package com.team21direction.pirategame.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.team21direction.pirategame.PirateGame;
import com.team21direction.pirategame.actors.Ship;

import java.util.Random;

public class MoveRandomly extends Action {

    float movingTime = 0.0f;
    Ship.Direction direction = null;

    /**
     * Move each NPC ship randomly every frame.
     * @param delta the time since the last frame.
     * @return whether the ship is active (hence, if false, the action should cease executing on that ship).
     */
    @Override
    public boolean act(float delta) {
        movingTime += delta;
        Ship actorShip = (Ship)actor;
        if (direction == null || movingTime >= 1.0f) {
            direction = Ship.Direction.values()[new Random().nextInt(Ship.Direction.values().length)];
            actorShip.setDirection(direction);
            movingTime = 0.0f;
        }
        float deltaX = (int)(Math.random() * 5);
        float deltaY = (int)(Math.random() * 5);
        if (direction == Ship.Direction.Down || direction == Ship.Direction.DownLeft || direction == Ship.Direction.DownRight) deltaY *= -1;
        if (direction == Ship.Direction.Left || direction == Ship.Direction.Right) deltaY *= 0;
        if (direction == Ship.Direction.Left || direction == Ship.Direction.DownLeft || direction == Ship.Direction.UpLeft) deltaX *= -1;
        if (direction == Ship.Direction.Up || direction == Ship.Direction.Down) deltaX *= 0;
        actorShip.move(deltaX, deltaY);
        return !(actorShip.isActive()); // only 'complete' the action when the Ship is killed.
    }
}
