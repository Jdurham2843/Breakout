package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import jad.breakout.model.Ball;
import jad.breakout.model.Breakout;

public class EntityManager {

    public static Breakout breakout;

    public static void update() {
        if (breakout == null) {
            create();
            return;
        }
        final Ball ball = breakout.getBall();

        if (ball.getPosition().y + ball.height >  Gdx.graphics.getHeight()) {
            ball.getPosition().y = Gdx.graphics.getHeight() - ball.height;
        } else if (ball.getPosition().y  <  0) {
            ball.getPosition().y = 0;
        }

        if (ball.getPosition().y + ball.height == Gdx.graphics.getHeight() || ball.getPosition().y == 0) {
            ball.setyVelocity(-ball.getyVelocity());
        }

        if (ball.getPosition().x + ball.width > Gdx.graphics.getWidth()) {
            ball.getPosition().x = Gdx.graphics.getWidth() - ball.width;
        } else if (ball.getPosition().x  < 0) {
            ball.getPosition().x = 0;
        }

        if (ball.getPosition().x + ball.width == Gdx.graphics.getWidth() || ball.getPosition().x == 0) {
            ball.setxVelocity(-ball.getxVelocity());
        }
        ball.update();

    }

    public static void reset() {
        create();
    }

    private static void create() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        final Ball ball = new Ball(ballVector, -8.0, -6.0);

        breakout = new Breakout(null, ball, null);
    }

}
