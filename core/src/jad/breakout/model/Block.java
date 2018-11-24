package jad.breakout.model;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Block {

    private final Color color;

    private final Vector2 position;

    public Block(Color color, Vector2 position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Vector2 getPosition() {
        return position;
    }

}
