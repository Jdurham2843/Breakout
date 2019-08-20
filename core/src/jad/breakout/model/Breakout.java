package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Breakout {

    private final Array<Block> blocks;

    private final Ball ball;

    private final Paddle paddle;

    private int points;

    public static Breakout initialize() {
        final Vector2 ballVector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        final Ball ball = new Ball(ballVector);

        final Paddle paddle = new Paddle(
                new Vector2(
                        (Gdx.graphics.getWidth() / 2) - (Paddle.WIDTH / 2),
                        0));

        final Array<Block> blocks = initializeBlocks();

        return new Breakout(blocks, ball, paddle);
    }

    private static final Color[] rowColors =
            new Color[] { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.SALMON, Color.RED };

    private static Array<Block> initializeBlocks() {
        final Array<Block> blocks = new Array<>();
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

    private Breakout(Array<Block> blocks, Ball ball, Paddle paddle) {
        this.blocks = blocks;
        this.ball = ball;
        this.paddle = paddle;
        points = 0;
    }

    public Array<Block> getBlocks() {
        return blocks;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int additionalPoints) {
        points += additionalPoints;
    }

}
