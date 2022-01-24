package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.HashMap;

public class Ship extends Actor {
    public enum Direction{Up, UpLeft, UpRight, Left, Right, Down, DownLeft, DownRight}
    private Direction direction = Direction.Right;

    private int health = 100;
    public static int damage = 10;
    public College parentCollege; // The College this ship is allied with.

    private final HashMap<Direction, Texture> textures;

    /**
     * Construct a new Ship which is a member of the supplied parentCollege.
     * @param parentCollege the College which the ship is allied to.
     */
    public Ship(College parentCollege) {
        this.parentCollege = parentCollege;
        textures = new HashMap<>();
        if (parentCollege == null) {
            textures.put(Direction.Up, new Texture(Gdx.files.internal("ship-up.png")));
            textures.put(Direction.UpLeft, new Texture(Gdx.files.internal("ship-upleft.png")));
            textures.put(Direction.UpRight, new Texture(Gdx.files.internal("ship-upright.png")));
            textures.put(Direction.Left, new Texture(Gdx.files.internal("ship-left.png")));
            textures.put(Direction.Right, new Texture(Gdx.files.internal("ship-right.png")));
            textures.put(Direction.Down, new Texture(Gdx.files.internal("ship-down.png")));
            textures.put(Direction.DownLeft, new Texture(Gdx.files.internal("ship-downleft.png")));
            textures.put(Direction.DownRight, new Texture(Gdx.files.internal("ship-downright.png")));
        } else {
            textures.put(Direction.Up, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-up.png")));
            textures.put(Direction.UpLeft, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-upleft.png")));
            textures.put(Direction.UpRight, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-upright.png")));
            textures.put(Direction.Left, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-left.png")));
            textures.put(Direction.Right, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-right.png")));
            textures.put(Direction.Down, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-down.png")));
            textures.put(Direction.DownLeft, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-downleft.png")));
            textures.put(Direction.DownRight, new Texture(Gdx.files.internal(parentCollege.getCollegeName() + "ship-downright.png")));
        }
    }

    public Ship() {
        this(null);
    }

    public boolean attack(int damage) {
        this.health -= damage;
        return this.health <= 0;
    }

    public int defend() {
        return damage;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.draw(textures.get(direction), 0, 0);
    }
}
