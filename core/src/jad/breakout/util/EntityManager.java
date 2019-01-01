package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import jad.breakout.model.Ball;

public class EntityManager {

    private static  Ball ball;

    public static void update() {
        if (ball == null) {
            create();
            return;
        }

        if (ball.getPosition().y + ball.height == Gdx.graphics.getHeight() ||
                ball.getPosition().y == 0) {
            ball.setyVelocity(-ball.getyVelocity());
        }
        if (ball.getPosition().x + ball.width == Gdx.graphics.getWidth() ||
                ball.getPosition().x == 0) {
            ball.setxVelocity(-ball.getxVelocity());
        }
        ball.update();

    }

    public static void reset() {
        create();
    }

    private static void create() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        ball = new Ball(ballVector, -5.0, -1.0);
    }

    public static Ball getBall() {
        return ball;
    }

}
