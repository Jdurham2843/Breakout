package jad.breakout.model;

import java.util.List;

public class Breakout {

    private final List<Block> blocks;

    private final Ball ball;

    private final Paddle paddle;

    public Breakout(List<Block> blocks, Ball ball, Paddle paddle) {
        this.blocks = blocks;
        this.ball = ball;
        this.paddle = paddle;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
