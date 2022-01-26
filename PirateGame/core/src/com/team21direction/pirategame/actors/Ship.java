package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.team21direction.pirategame.actions.MoveRandomly;

import java.util.HashMap;

public class Ship extends Actor {
    public enum Direction{Up, UpLeft, UpRight, Left, Right, Down, DownLeft, DownRight}
    private Direction direction = Direction.Right;

    private boolean isActive = true;

    private int health = 100;
    public static int damage = 10;
    public College parentCollege; // The College this ship is allied with.

    private final HashMap<Direction, Texture> textures;

    private float x = 0.0f;
    private float y = 0.0f;

    /**
     * Construct a new Ship which is a member of the supplied parentCollege.
     * @param parentCollege the College which the ship is allied to.
     */
    public Ship(College parentCollege) {
        this.parentCollege = parentCollege;
        textures = new HashMap<>();
        textures.put(Direction.Up, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-up.png")));
        textures.put(Direction.UpLeft, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-upleft.png")));
        textures.put(Direction.UpRight, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-upright.png")));
        textures.put(Direction.Left, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-left.png")));
        textures.put(Direction.Right, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-right.png")));
        // TODO: textures.put(Direction.Down, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-down.png")));
        textures.put(Direction.Down, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-up.png")));
        textures.put(Direction.DownLeft, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-downleft.png")));
        textures.put(Direction.DownRight, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-downright.png")));

        this.addAction(new MoveRandomly());
    }

    public boolean attack(int damage) {
        this.health -= damage;
        isActive = this.health > 0;
        return isActive;
    }

    public int defend() {
        return damage;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean isActive() {
        return isActive;
    }

    public void draw(Batch batch, float parentAlpha) {
        if (isActive) {
            batch.draw(textures.get(direction), x, y);
        }
    }
}
