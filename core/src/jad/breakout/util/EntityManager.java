package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import jad.breakout.model.Ball;
import jad.breakout.model.Block;
import jad.breakout.model.Breakout;
import jad.breakout.model.Paddle;

import java.util.Random;

public class EntityManager {

    public static Breakout breakout;

    public static void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        final Ball ball = breakout.getBall();
        final Paddle paddle = breakout.getPaddle();
        final Array<Block> blocks = breakout.getBlocks();

        ball.update(deltaTime);
        paddle.update(deltaTime);

        if (ball.getPosition().overlaps(paddle.getPosition())) {
            ball.getPosition().y = paddle.getHeight();
            ball.setyVelocity(-ball.getyVelocity());
        } else {
            handleBallBlocksCollision(ball, blocks);
        }
    }

    private static void handleBallBlocksCollision(final Ball ball, final Array<Block> blocks) {
        for(Block block : blocks) {
            if (ball.getPosition().overlaps(block.getPosition())) {
                ball.getPosition().y = block.getPosition().y - ball.getHeight() - 12f;
                ball.setyVelocity(-ball.getyVelocity());
                return;
            }
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

        final Random random = new Random();
        final float height = (Gdx.graphics.getHeight() / 2.0f) + 30f;
        int cursor = 0;
        while (cursor < Gdx.graphics.getWidth() + Block.WIDTH) {
            final float red = random.nextInt(255) / 255f;
            final float green = random.nextInt(255) / 255f;
            final float blue = random.nextInt(255) / 255f;

            blocks.add(
                    new Block(
                            new Color(red, green, blue, 1),
                            new Vector2(cursor, height)));
            cursor += Block.WIDTH;
        }

        return blocks;
    }

}
