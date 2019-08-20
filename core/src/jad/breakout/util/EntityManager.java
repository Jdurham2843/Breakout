package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import jad.breakout.model.Ball;
import jad.breakout.model.Block;
import jad.breakout.model.Breakout;
import jad.breakout.model.Paddle;

import java.util.Arrays;
import java.util.List;
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

        paddle.handleCollision(ball, deltaTime);
        handleBallBlocksCollision(ball, blocks, deltaTime);
    }

    private static final List<Color> speedUpColors = Arrays.asList(Color.BLUE);
    private static boolean colorSpeedUpApplied = false;
    private static void handleBallBlocksCollision(final Ball ball, final Array<Block> blocks, float deltaTime) {
        for(Block block : blocks) {
            if (block.handleCollision(ball, deltaTime)) {
                if (!colorSpeedUpApplied && speedUpColors.contains(block.getColor())) {
                    ball.applySpeedMultiplier(2);
                    colorSpeedUpApplied = true;
                }
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

    private static final Color[] rowColors =
            new Color[] { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.SALMON, Color.RED };

    private static Array<Block> initializeBlocks() {
        final Array<Block> blocks = new Array<>();

        final Random random = new Random();
        float height = (Gdx.graphics.getHeight() / 2.0f) + 30f;

        for (Color color : rowColors) {
            for (int cursor = 0; cursor < Gdx.graphics.getWidth() + Block.WIDTH; cursor += Block.WIDTH) {
                final Block block = new Block(color, new Vector2(cursor, height));
                blocks.add(block);
            }

            height += Block.HEIGHT;
        }

        return blocks;
    }

}
