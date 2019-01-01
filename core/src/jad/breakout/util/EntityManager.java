package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import jad.breakout.model.Ball;
import jad.breakout.model.Breakout;
import jad.breakout.model.GameObject;
import jad.breakout.model.Paddle;

public class EntityManager {

    public static Breakout breakout;

    public static void update() {
        if (breakout == null) {
            create();
            return;
        }
        final Ball ball = breakout.getBall();
        final Paddle paddle = breakout.getPaddle();

        moveBackOntoScreen(ball);

        if (ball.getPosition().overlaps(paddle.getPosition())) {
            ball.getPosition().y = paddle.getHeight();
            ball.setyVelocity(-ball.getyVelocity());
        }
        ball.update();

        moveBackOntoScreen(paddle);
        paddle.update();

    }

    public static void reset() {
        create();
    }

    private static void create() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        final Ball ball = new Ball(ballVector, -8.0f, -6.0f);

        final Paddle paddle = new Paddle(
                new Vector2(
                        (Gdx.graphics.getWidth() / 2) - (Paddle.WIDTH / 2),
                        0));

        breakout = new Breakout(null, ball, paddle);
    }

    private static void moveBackOntoScreen(final GameObject gameObject) {
        if (gameObject.getVector().y + gameObject.getHeight() >  Gdx.graphics.getHeight()) {
            gameObject.getVector().y = Gdx.graphics.getHeight() - gameObject.getHeight();
        } else if (gameObject.getVector().y  <  0) {
            gameObject.getVector().y = 0;
        }

        if (gameObject.getVector().x + gameObject.getWidth() > Gdx.graphics.getWidth()) {
            gameObject.getVector().x = Gdx.graphics.getWidth() - gameObject.getWidth();
        } else if (gameObject.getVector().x  < 0) {
            gameObject.getVector().x = 0;
        }
    }

}
