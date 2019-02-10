package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import jad.breakout.model.Ball;
import jad.breakout.model.Block;
import jad.breakout.model.Breakout;
import jad.breakout.model.Paddle;

public class EntityManager {

    public static Breakout breakout;

    public static void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        breakout.getBall().update(deltaTime);
        breakout.getPaddle().update(deltaTime);

        if (breakout.getBall().getPosition().overlaps(breakout.getPaddle().getPosition())) {
            breakout.getBall().getPosition().y = breakout.getPaddle().getHeight();
            breakout.getBall().setyVelocity(-breakout.getBall().getyVelocity());
        }
    }

    public static void reset() {
        create();
    }

    public static void create() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        final Ball ball = new Ball(ballVector);

        final Paddle paddle = new Paddle(
                new Vector2(
                        (Gdx.graphics.getWidth() / 2) - (Paddle.WIDTH / 2),
                        0));

        final Array<Block> blocks = initializeBlocks();

        breakout = new Breakout(blocks, ball, paddle);
    }

    private static Array<Block> initializeBlocks() {
        final Array<Block> blocks = new Array<>();

        int cursor = 0;
        while (cursor < Gdx.graphics.getWidth() + Block.WIDTH) {
            blocks.add(
                    new Block(
                            new Color(0, 1, 0, 1),
                            new Vector2(cursor, Gdx.graphics.getHeight() / 2)));
            cursor += Block.WIDTH;
        }

        return blocks;
    }

}
