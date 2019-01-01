package jad.breakout.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball  {

    public static final int width = 50;

    public static final int height = 50;

    private static final Color color = new Color(1, 0, 0, 1);

    private Vector2 position;

    private Double xVelocity;

    private Double yVelocity;

    public Ball(Vector2 position, Double xVelocity, Double yVelocity) {
        this.position = position;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update() {
        this.position.y += this.yVelocity;
        this.position.x += this.xVelocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(this.getPosition().x, this.getPosition().y, Ball.width, Ball.height);
    }

    public Double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(Double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public Double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(Double yVelocity) {
        this.yVelocity = yVelocity;
    }
}
