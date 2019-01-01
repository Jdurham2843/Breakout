package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball implements GameObject {

    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;

    private final Color color = new Color(1, 0, 0, 1);

    private Vector2 position;

    private float xVelocity;

    private float yVelocity;

    public Ball(Vector2 position, float xVelocity, float yVelocity) {
        this.position = position;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update() {
        if (getVector().y + HEIGHT == Gdx.graphics.getHeight() || getVector().y == 0) {
            setyVelocity(-getyVelocity());
        }

        if (getVector().x + WIDTH == Gdx.graphics.getWidth() || getVector().x == 0) {
            setxVelocity(-getxVelocity());
        }

        this.position.y += this.yVelocity;
        this.position.x += this.xVelocity;
    }

    @Override
    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(this.getVector().x, this.getVector().y, Ball.WIDTH / 2.0f);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public  int getHeight() {
        return HEIGHT;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Vector2 getVector() {
        return position;
    }

    @Override
    public Rectangle getPosition() {
        return new Rectangle(position.x, position.y, WIDTH, HEIGHT);
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
