package jad.breakout.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall extends GameObject {

    private final Vector2 positionVector;

    private final int height;

    private final int width;

    private final Color color = Color.GRAY;

    public Wall(Vector2 positionVector, int width, int height) {
        this.positionVector = positionVector;
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2 getVector() {
        return positionVector;
    }

    @Override
    public Rectangle getPosition() {
        return new Rectangle(positionVector.x, positionVector.y, width, height);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void update(float deltaTime) { }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(positionVector.x, positionVector.y, width, height);
    }
}
