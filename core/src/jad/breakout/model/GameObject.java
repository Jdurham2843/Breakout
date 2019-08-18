package jad.breakout.model;

import com.badlogic.gdx.Game;
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

    default boolean handleCollision(final GameObject otherObject, final float deltaTime) {
        if (otherObject.getPosition().overlaps(getPosition())) {
            rewindUntilOverlapIsGone(otherObject, deltaTime);
            if (isBottomCollision(otherObject) || isTopCollision(otherObject)) {
                otherObject.setyVelocity(-otherObject.getyVelocity());
                return true;
            } else if (isLeftCollision(otherObject) || isRightCollision(otherObject)) {
                otherObject.setxVelocity(-otherObject.getxVelocity());
                return true;
            }
        }
        return false;
    }

    private void rewindUntilOverlapIsGone(final GameObject otherObject, final float deltaTime) {
        while (otherObject.getPosition().overlaps(getPosition())) {
            otherObject.getVector().x -= otherObject.getxVelocity() * deltaTime;
            otherObject.getVector().y -= otherObject.getyVelocity() * deltaTime;
        }
    }

    private boolean isBottomCollision(final GameObject otherObject) {
        final float otherObjectYPosition = otherObject.getPosition().y + otherObject.getHeight();

        return otherObjectYPosition < getPosition().y;
    }

    private boolean isTopCollision(final GameObject otherObject) {
        final float otherObjectYPosition = otherObject.getPosition().y;

        return otherObjectYPosition > getPosition().y;
    }

    private boolean isRightCollision(final GameObject otherObject) {
        final float otherObjectXPosition = otherObject.getPosition().x;

        return otherObjectXPosition > getPosition().x;
    }

    private boolean isLeftCollision(final GameObject otherObject) {
        final float otherObjectXPosition = otherObject.getPosition().x + otherObject.getWidth();

        return otherObjectXPosition < getPosition().x;
    }

}
