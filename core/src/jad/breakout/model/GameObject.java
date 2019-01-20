package jad.breakout.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface GameObject {

    Vector2 getVector();

    Rectangle getPosition();

    int getHeight();

    int getWidth();

    void update(float deltaTime);

    void render(ShapeRenderer shapeRenderer);

}
