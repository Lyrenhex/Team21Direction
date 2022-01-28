package com.team21direction.pirategame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.team21direction.pirategame.actions.MoveRandomly;

import java.util.HashMap;

public class Ship extends GameActor {
    public enum Direction{Up, UpLeft, UpRight, Left, Right, Down, DownLeft, DownRight}
    private Direction direction = Direction.Right;

    public College parentCollege; // The College this ship is allied with.

    private final HashMap<Direction, Texture> textures;
    private Sprite texture;

    /**
     * Construct a new Ship which is a member of the supplied parentCollege.
     * @param parentCollege the College which the ship is allied to.
     */
    public Ship(College parentCollege, boolean isPlayer) {
        this.radius = 150;

        this.parentCollege = parentCollege;
        textures = new HashMap<>();
        textures.put(Direction.Up, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-up.png")));
        textures.put(Direction.UpLeft, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-upleft.png")));
        textures.put(Direction.UpRight, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-upright.png")));
        textures.put(Direction.Left, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-left.png")));
        textures.put(Direction.Right, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-right.png")));
        textures.put(Direction.Down, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-down.png")));
        textures.put(Direction.DownLeft, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-downleft.png")));
        textures.put(Direction.DownRight, new Texture(Gdx.files.internal("ships/" + parentCollege.getCollegeName() + "-ship-downright.png")));

        texture = new Sprite(textures.get(direction));
        if (!isPlayer) this.addAction(new MoveRandomly());
    }

    public Ship(College parentCollege) {
        this(parentCollege, false);
    }

    /**
     * Set the direction the ship is facing.
     * @param direction the new direction the ship is facing.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
        texture = new Sprite(textures.get(direction));
    }

    /**
     * Draw the ship on the screen.
     * This should be called once per frame by `Stage.draw()`.
     * @param batch the Batch to draw the ship as part of for GPU optimisation.
     * @param parentAlpha the parent Actor's alpha value for alpha blending.
     */
    public void draw(Batch batch, float parentAlpha) {
        if (isActive()) {
            batch.draw(texture, getX() - (texture.getWidth() / 2), getY() - (texture.getHeight() / 2));
        }
    }
}
