package jad.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import jad.breakout.model.Ball;
import jad.breakout.model.Paddle;
import jad.breakout.util.EntityManager;
import jad.breakout.util.ExtendedScreen;
import jad.breakout.util.ScreenOptions;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ExtendedScreen {

    private final OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    private final ShapeRenderer shapeRenderer;

    public static ScreenOptions getScreenOptions() {
        return new ScreenOptions(GameScreen.class, GameScreen.getStateChangeKeys());
    }

    private static List<Integer> getStateChangeKeys() {
        final List<Integer> stateChangeKeys = new ArrayList<>();
        return stateChangeKeys;
    }

    public GameScreen(final BreakoutApplication breakoutApplication) {
        super(breakoutApplication);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        this.spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);

    }

    @Override
    public void show() {

    }

    private boolean paused = false;

    private final BitmapFont bitmapFont = new BitmapFont();

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (paused) paused = false;
            else paused = true;
        }

        if (! paused) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            if (EntityManager.breakout == null) {
                EntityManager.create();
            }

            final Ball ball = EntityManager.breakout.getBall();
            final Paddle paddle = EntityManager.breakout.getPaddle();

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            ball.render(shapeRenderer);
            paddle.render(shapeRenderer);
            EntityManager.breakout.getBlocks().forEach(block -> {
                block.render(shapeRenderer);
            });
            shapeRenderer.end();

            spriteBatch.begin();
            bitmapFont.draw(spriteBatch, Integer.toString(EntityManager.breakout.getPoints()), 10, 10);
            spriteBatch.end();

            EntityManager.update();

            if (this.game.getGuiStateMachine().shouldChangeState()) {
                this.game.getGuiStateMachine().determineScreen(this.game);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}