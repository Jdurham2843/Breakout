package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import jad.breakout.util.DimensionHelper;

import java.util.Arrays;
import java.util.List;

public class Breakout {

    private final Array<Block> blocks;

    private final Ball ball;

    private final Paddle paddle;

    private final List<Wall> walls;

    private int points;

    public static Breakout initialize() {
        final Vector2 ballVector = new Vector2(DimensionHelper.playAreaWidth() / 2, DimensionHelper.playAreaHeight() / 2);
        final Ball ball = new Ball(ballVector);

        final Paddle paddle = new Paddle(
                new Vector2(
                        (DimensionHelper.playAreaWidth() / 2) - (Paddle.WIDTH / 2),
                        0));

        final Array<Block> blocks = initializeBlocks();
        final List<Wall> walls = initializeWalls();

        return new Breakout(blocks, ball, paddle, walls);
    }

    private static final Color[] rowColors =
            new Color[] { Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.SALMON, Color.RED };

    private static Array<Block> initializeBlocks() {
        final Array<Block> blocks = new Array<>();
        float height = (DimensionHelper.playAreaHeight() / 2.0f) + 30f;

        for (Color color : rowColors) {
            for (int cursor = sideWallWidth; cursor + Block.WIDTH < DimensionHelper.playAreaWidth() - sideWallWidth; cursor += Block.WIDTH) {
                final Block block = new Block(color, new Vector2(cursor, height));
                blocks.add(block);
            }

            height += Block.HEIGHT;
        }

        return blocks;
    }

    private static final int sideWallWidth = (int) (Gdx.graphics.getWidth() * .02);
    private static List<Wall> initializeWalls() {
        final int sideWallWidth = (int) (Gdx.graphics.getWidth() * .02);
        final int sideWallHeight = (int) (Gdx.graphics.getHeight() * .9);
        final Vector2 position = new Vector2(0, 0);
        final Wall leftWall = new Wall(position, sideWallWidth, sideWallHeight);

        final int rightWallXPosition = Gdx.graphics.getWidth() - sideWallWidth;
        final Vector2 rightWallPosition = new Vector2(rightWallXPosition, 0);
        final Wall rightWall = new Wall(rightWallPosition, sideWallWidth, sideWallHeight);

        int topWallWidth = Gdx.graphics.getWidth();
        int topWallHeight = sideWallWidth;
        int topWallYPosition = sideWallHeight - topWallHeight;
        final Vector2 topWallPosition = new Vector2(0, topWallYPosition);
        final Wall topWall = new Wall(topWallPosition, topWallWidth, topWallHeight);

        return Arrays.asList(leftWall, rightWall, topWall);
    }

    private Breakout(Array<Block> blocks, Ball ball, Paddle paddle, List<Wall> walls) {
        this.blocks = blocks;
        this.ball = ball;
        this.paddle = paddle;
        this.points = 0;
        this.walls = walls;
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

    public List<Wall> getWalls() {
        return walls;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int additionalPoints) {
        points += additionalPoints;
    }

}
