package jad.breakout.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface GameObject {

    Vector2 getVector();

    Rectangle getPosition();

    int getHeight();

    int getWidth();

    default float getyVelocity() {
        return 0f;
    }

    default void setyVelocity(float newVelocity) { }

    default float getxVelocity() { return 0f; }

    default void setxVelocity(final float xVelocity) {}

    void update(float deltaTime);

    void render(ShapeRenderer shapeRenderer);

    default boolean handleCollision(GameObject otherObject, final float deltaTime) {
        if (otherObject.getPosition().overlaps(getPosition())) {
            rewindUntilOverlapIsGone(otherObject, deltaTime);

            if (isBottomCollision(otherObject)) {
                otherObject.setyVelocity(-otherObject.getyVelocity());
                return true;
            }
            return false;
        }
        return false;
    }

    private void rewindUntilOverlapIsGone(GameObject otherObject, final float deltaTime) {
        while (otherObject.getPosition().overlaps(getPosition())) {
            otherObject.getVector().x -= otherObject.getxVelocity() * deltaTime;
            otherObject.getVector().y -= otherObject.getyVelocity() * deltaTime;
        }
    }

    private boolean isBottomCollision(final GameObject otherObject) {
        final float otherObjectYPosition = otherObject.getPosition().y + otherObject.getHeight();

        return otherObjectYPosition < getPosition().y;
    }

}
