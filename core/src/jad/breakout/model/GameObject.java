package jad.breakout.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

    public abstract Vector2 getVector();

    public abstract Rectangle getPosition();

    public abstract int getHeight();

    public abstract int getWidth();

    public float getyVelocity() {
        return 0f;
    }

    public Vector2 getDirection() {
        return new Vector2(0f, 0f);
    }

    public float getxVelocity() { return 0f; }

    public abstract void update(float deltaTime);

    public abstract void render(ShapeRenderer shapeRenderer);

    public boolean handleCollision(final GameObject otherObject, final float deltaTime) {
        if (otherObject.getPosition().overlaps(getPosition())) {
            rewindUntilOverlapIsGone(otherObject, deltaTime);

            if (isTopCollision(otherObject)) {
                handleTopCollision(otherObject);
                return true;
            } else if (isBottomCollision(otherObject)) {
                handleBottomCollision(otherObject);
                return true;
            } else if (isLeftCollision(otherObject)) {
                handleLeftCollision(otherObject);
                return true;
            } else if (isRightCollision(otherObject)) {
                handleRightCollision(otherObject);
                return true;
            }
        }
        return false;
    }

    protected void rewindUntilOverlapIsGone(final GameObject otherObject, final float deltaTime) {
        while (otherObject.getPosition().overlaps(getPosition())) {
            otherObject.getVector().x -= otherObject.getxVelocity() * deltaTime;
            otherObject.getVector().y -= otherObject.getyVelocity() * deltaTime;
        }
    }

    protected boolean isBottomCollision(final GameObject otherObject) {
        final float otherObjectYPosition = otherObject.getVector().y + otherObject.getHeight();

        return otherObjectYPosition < getVector().y;
    }

    protected boolean isTopCollision(final GameObject otherObject) {
        final float otherObjectYPosition = otherObject.getVector().y;

        return otherObjectYPosition > getVector().y + getHeight();
    }

    protected boolean isRightCollision(final GameObject otherObject) {
        final float otherObjectXPosition = otherObject.getPosition().x;

        return otherObjectXPosition > getVector().x + getWidth();
    }

    protected boolean isLeftCollision(final GameObject otherObject) {
        final float otherObjectXPosition = otherObject.getVector().x + otherObject.getWidth();

        return otherObjectXPosition < getVector().x;
    }

    protected void handleTopCollision(final GameObject otherObject) {
        otherObject.getDirection().y *= -1;
    }

    protected void handleBottomCollision(final GameObject otherObject) {
        otherObject.getDirection().y *= -1;
    }

    protected void handleLeftCollision(final GameObject otherObject) {
        otherObject.getDirection().x *= -1;
    }

    protected void handleRightCollision(final GameObject otherObject) {
        otherObject.getDirection().x *= -1;
    }

}
