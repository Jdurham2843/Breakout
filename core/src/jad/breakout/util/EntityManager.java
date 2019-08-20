package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import jad.breakout.model.Ball;
import jad.breakout.model.Block;
import jad.breakout.model.Breakout;
import jad.breakout.model.Paddle;

import java.util.Arrays;
import java.util.List;

public class EntityManager {

    public Breakout breakout;

    public static EntityManager initialize() {
        final Breakout breakout = Breakout.initialize();
        final EntityManager entityManager = new EntityManager(breakout);
        return entityManager;
    }

    private EntityManager(final Breakout breakout) {
        this.breakout = breakout;
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        final Ball ball = breakout.getBall();
        final Paddle paddle = breakout.getPaddle();
        final Array<Block> blocks = breakout.getBlocks();

        ball.update(deltaTime);
        paddle.update(deltaTime);

        paddle.handleCollision(ball, deltaTime);
        handleBallBlocksCollision(ball, blocks, deltaTime);
    }

    private final List<Color> speedUpColors = Arrays.asList(Color.BLUE);
    private boolean colorSpeedUpApplied = false;
    private void handleBallBlocksCollision(final Ball ball, final Array<Block> blocks, float deltaTime) {
        for(Block block : blocks) {
            if (block.handleCollision(ball, deltaTime)) {
                if (!colorSpeedUpApplied && speedUpColors.contains(block.getColor())) {
                    ball.applySpeedMultiplier(2);
                    colorSpeedUpApplied = true;
                }

                breakout.addPoints(1);
                return;
            }
        }
    }

    private final BitmapFont scoreFont = new BitmapFont();
    public void render(final SpriteBatch spriteBatch, final ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        breakout.getBall().render(shapeRenderer);
        breakout.getPaddle().render(shapeRenderer);
        breakout.getBlocks().forEach(block -> {
            block.render(shapeRenderer);
        });
        shapeRenderer.end();

        spriteBatch.begin();
        scoreFont.draw(spriteBatch, Integer.toString(breakout.getPoints()), 10, 10);
        spriteBatch.end();
    }

}
