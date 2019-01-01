package jad.breakout.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ball  implements GameObject {

    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;

    private static final Color color = new Color(1, 0, 0, 1);

    private Vector2 position;

    private float xVelocity;

    private float yVelocity;

    public Ball(Vector2 position, float xVelocity, float yVelocity) {
        this.position = position;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update() {
        this.position.y += this.yVelocity;
        this.position.x += this.xVelocity;
    }

    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(this.getPosition().x, this.getPosition().y, Ball.WIDTH / 2.0f);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public  int getHeight() {
        return HEIGHT;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }
}
