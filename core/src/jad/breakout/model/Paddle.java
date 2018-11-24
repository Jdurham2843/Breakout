package jad.breakout.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Paddle {

    private final Texture texture;

    private final Vector2 position;

    public Paddle(Texture texture, Vector2 position) {
        this.texture = texture;
        this.position = position;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return position;
    }

}
