package jad.breakout.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Ball  {

    public static final String IMAGE_PATH = "image-path";

    private final Vector2 position;

    private final Double xVelocity;

    private final Double yVelocity;

    public Ball(Vector2 position, Double xVelocity, Double yVelocity) {
        this.position = position;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Double getxVelocity() {
        return xVelocity;
    }

    public Double getyVelocity() {
        return yVelocity;
    }

}
