package jad.breakout.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block extends GameObject {

    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;

    private final Color color;

    private final Vector2 vector;
    private boolean active = true;

    public Block(Color color, Vector2 vector) {
        this.color = color;
        this.vector = vector;
    }

    @Override
    public Vector2 getVector() {
        return vector;
    }

    @Override
    public Rectangle getPosition() {
        return new Rectangle(vector.x, vector.y, WIDTH, HEIGHT);
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

    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        if (active) {
            shapeRenderer.setColor(color);
            shapeRenderer.rect(this.getVector().x, this.getVector().y, WIDTH, HEIGHT);
        }
    }

    @Override
    public boolean handleCollision(final GameObject otherObject, final float deltaTime) {
        if (!active) {
            return false;
        }

        final boolean collisionDetected = super.handleCollision(otherObject, deltaTime);

        if (collisionDetected) {
            active = false;
        }

        return collisionDetected;
    }

}
