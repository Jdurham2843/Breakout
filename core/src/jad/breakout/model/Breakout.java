package jad.breakout.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.List;

public class Breakout {

    private final Array<Block> blocks;

    private final Ball ball;

    private final Paddle paddle;

    private int points;

    public Breakout(Array<Block> blocks, Ball ball, Paddle paddle) {
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
