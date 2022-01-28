package com.team21direction.pirategame.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.team21direction.pirategame.PirateGame;
import com.team21direction.pirategame.screens.MainScreen;

public class GameActor extends Actor {
    private boolean isActive = true;
    private final int maxHealth = 100;
    private int health = maxHealth;
    private static int damage = 10;

    private float x = 0.0f;
    private float y = 0.0f;

    protected float radius;

    public MainScreen screen;

    public GameActor(MainScreen screen) {
        this.screen = screen;
    }

    /**
     * Return the immutable max (starting) health of the actor.
     * @return an integer representing the maximum health of the actor.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Return the current health of the actor.
     * @return an integer representing the actor's current health: health() <= maxHealth()
     */
    public int getHealth() {
        return health;
    }

    /**
     * Return the actor's `x` coordinate in the world.
     * @return a float representing the actor's location in the game world's x-axis.
     */
    public float getX() {
        return x;
    }

    /**
     * Return the actor's `y` coordinate in the world.
     * @return a float representing the actor's location in the game world's y-axis.
     */
    public float getY() {
        return y;
    }

    /**
     * Return whether the actor is still active (ie, not defeated).
     * @return true if the actor is still active.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Reduce the actor's health by the appropriate damage, and update `isActive` as appropriate.
     * @param damage the amount of damage to inflict on the actor.
     * @return the new value of `isActive`.
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
    public int getDamage() {
        return damage;
    }

    /**
     * Increase **all** actors' damage by the specified delta, to allow for
     * an increase in difficulty.
     * @param delta the amount to increase actors' damage by.
     */
    public void increaseDamage(int delta) {
        damage += delta;
    }

    /**
     * Change the actor's location in the game world by absolute value.
     * @param x the x-coordinate of the new location.
     * @param y the y-coordinate of the new location.
     */
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move the actor's location relative to their old position in the game world.
     * @param deltaX how far to move the actor along the x-axis (direction determined by sign).
     * @param deltaY how far to move the actor along the y-axis (direction determined by sign).
     * @return whether the movement took place or not (false if OOB or collision).
     */
    public boolean move(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        if (this.x + deltaX >= PirateGame.WORLD_WIDTH / 2.0f
            || this.x + deltaX <= -(PirateGame.WORLD_WIDTH / 2.0f)
            || this.y + deltaY >= PirateGame.WORLD_HEIGHT / 2.0f
            || this.y + deltaY <= -(PirateGame.WORLD_HEIGHT / 2.0f)
            || screen.getCollision(this.x + deltaX, this.y + deltaY) != null)
            return false;
        return true;
    }

    /**
     * Returns
     * @param x
     * @param y
     * @return
     */
    public boolean collision(float x, float y) {
        return (this.x - this.radius <= x && x <= this.x + this.radius
                && this.y - this.radius <= y && y <= this.y + this.radius);
    }
}
