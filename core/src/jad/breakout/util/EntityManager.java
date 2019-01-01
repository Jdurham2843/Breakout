package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import jad.breakout.model.Ball;
import jad.breakout.model.Breakout;
import jad.breakout.model.GameObject;

public class EntityManager {

    public static Breakout breakout;

    public static void update() {
        if (breakout == null) {
            create();
            return;
        }
        final Ball ball = breakout.getBall();

        moveBackOntoScreen(ball);

        if (ball.getPosition().y + ball.HEIGHT == Gdx.graphics.getHeight() || ball.getPosition().y == 0) {
            ball.setyVelocity(-ball.getyVelocity());
        }

        if (ball.getPosition().x + ball.WIDTH == Gdx.graphics.getWidth() || ball.getPosition().x == 0) {
            ball.setxVelocity(-ball.getxVelocity());
        }
        ball.update();

    }

    public static void reset() {
        create();
    }

    private static void create() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        final Ball ball = new Ball(ballVector, -8.0f, -6.0f);

        breakout = new Breakout(null, ball, null);
    }

    private static void moveBackOntoScreen(final GameObject gameObject) {
        if (gameObject.getPosition().y + gameObject.getHeight() >  Gdx.graphics.getHeight()) {
            gameObject.getPosition().y = Gdx.graphics.getHeight() - gameObject.getHeight();
        } else if (gameObject.getPosition().y  <  0) {
            gameObject.getPosition().y = 0;
        }

        if (gameObject.getPosition().x + gameObject.getWidth() > Gdx.graphics.getWidth()) {
            gameObject.getPosition().x = Gdx.graphics.getWidth() - gameObject.getWidth();
        } else if (gameObject.getPosition().x  < 0) {
            gameObject.getPosition().x = 0;
        }
    }

}
