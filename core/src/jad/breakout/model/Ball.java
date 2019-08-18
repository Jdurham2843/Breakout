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

    public Ball(Vector2 position) {
        this.position = position;
        this.xVelocity = -500.0f;
        this.yVelocity = - 350.0f;
    }

    @Override
    public void update(float deltaTime) {
        this.moveBackOnScreen();
        if (getVector().y + HEIGHT == Gdx.graphics.getHeight() || getVector().y == 0) {
            setyVelocity(-getyVelocity());
        }

        if (getVector().x + WIDTH == Gdx.graphics.getWidth() || getVector().x == 0) {
            setxVelocity(-getxVelocity());
        }

        this.position.y += this.yVelocity * deltaTime;
        this.position.x += this.xVelocity * deltaTime;
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

    @Override
    public float getxVelocity() {
        return xVelocity;
    }

    @Override
    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    @Override
    public float getyVelocity() {
        return yVelocity;
    }

    @Override
    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }
}
