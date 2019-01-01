package jad.breakout.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Paddle implements GameObject{

    public static final int WIDTH = 80;

    public static final int HEIGHT = 20;

    private static final Color color = new Color(1, 1, 1, 1);

    private final Vector2 position;

    public Paddle(Vector2 position) {
        this.position = position;
    }

    public void render(final ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(this.getPosition().x, this.getPosition().y, Paddle.WIDTH, Paddle.HEIGHT);
    }

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

}
