package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Paddle extends GameObject {

    public static final int WIDTH = 200;

    public static final int HEIGHT = 20;

    private static final Color color = new Color(1, 1, 1, 1);

    private final Vector2 position;

    private float xVelocity = 600;

    public Paddle(Vector2 position) {
        this.position = position;
    }

    @Override
    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(this.getVector().x, this.getVector().y, Paddle.WIDTH, Paddle.HEIGHT);
    }

    public Vector2 getVector() {
        return position;
    }

    @Override
    public Rectangle getPosition() {
        return new Rectangle(position.x, position.y, WIDTH, HEIGHT);
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public void update(float deltaTime) {
        moveBackOntoScreen();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            getVector().x -= this.xVelocity * deltaTime;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            getVector().x += this.xVelocity * deltaTime;
        }
    }

    private void moveBackOntoScreen() {
        if (getVector().y + getHeight() >  Gdx.graphics.getHeight()) {
            getVector().y = Gdx.graphics.getHeight() - getHeight();
        } else if (getVector().y  <  0) {
            getVector().y = 0;
        }

        if (getVector().x + getWidth() > Gdx.graphics.getWidth()) {
            getVector().x = Gdx.graphics.getWidth() - getWidth();
        } else if (getVector().x  < 0) {
            getVector().x = 0;
        }
    }

    @Override
    protected void handleTopCollision(final GameObject otherObject) {
        final float section1 = getVector().x + (WIDTH * (1.0f / 3.0f));
        final float section2 = getVector().x + (WIDTH * (2.0f / 3.0f));

        final float otherObjectsCentralPosition = otherObject.getVector().x + (otherObject.getWidth() * .5f);
        if (otherObjectsCentralPosition < section1) {
            otherObject.getDirection().set(-0.7f, 0.3f);
        } else if (otherObjectsCentralPosition < section2) {
            otherObject.getDirection().set(0.0f, 1.0f);
        } else {
            otherObject.getDirection().set(0.7f, 0.3f);
        }
    }

    @Override
    protected void handleRightCollision(final GameObject otherObject) {
        otherObject.getDirection().set(.8f, 2f);
    }

    @Override
    protected void handleLeftCollision(final GameObject otherObject) {
        otherObject.getDirection().set(-.8f, 2f);
    }

}
