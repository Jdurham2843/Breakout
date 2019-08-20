package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball extends GameObject {

    public static final int WIDTH = 20;

    public static final int HEIGHT = 20;

    private final Color color = new Color(1, 0, 0, 1);

    private Vector2 position;

    private Vector2 direction;

    private float speed = 700.0f;

    public Ball(Vector2 position) {
        this.position = position;
        this.direction = new Vector2(-.50f, -.50f);
    }

    @Override
    public void update(float deltaTime) {
        this.moveBackOnScreen();
        if (getVector().y + HEIGHT == Gdx.graphics.getHeight() || getVector().y == 0) {
            direction.y = -direction.y;
        }

        if (getVector().x + WIDTH == Gdx.graphics.getWidth() || getVector().x == 0) {
            direction.x = -direction.x;
        }

        this.position.y += getyVelocity() * deltaTime;
        this.position.x += getxVelocity() * deltaTime;
    }

    private void moveBackOnScreen() {
        if (this.getVector().y + this.getHeight() >  Gdx.graphics.getHeight()) {
            this.getVector().y = Gdx.graphics.getHeight() - this.getHeight();
        } else if (this.getVector().y  <  0) {
            this.getVector().y = 0;
        }

        if (this.getVector().x + this.getWidth() > Gdx.graphics.getWidth()) {
            this.getVector().x = Gdx.graphics.getWidth() - this.getWidth();
        } else if (this.getVector().x < 0) {
            this.getVector().x = 0;
        }
    }

    @Override
    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(this.getVector().x, this.getVector().y, Ball.WIDTH / 2.0f);
    }

    public void applySpeedMultiplier(final float speedMultiplier) {
        speed *= speedMultiplier;
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
    public Vector2 getDirection() {
        return direction;
    }

    @Override
    public Vector2 getVector() {
        return position;
    }

    @Override
    public Rectangle getPosition() {
        return new Rectangle(position.x, position.y, WIDTH, HEIGHT);
    }

    @Override
    public float getxVelocity() {
        return speed * direction.x;
    }

    @Override
    public float getyVelocity() {
        return speed * direction.y;
    }
}
