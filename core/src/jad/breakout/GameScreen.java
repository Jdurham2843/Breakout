package jad.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import jad.breakout.util.EntityManager;
import jad.breakout.util.ExtendedScreen;
import jad.breakout.util.ScreenOptions;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ExtendedScreen {

    private final OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    private final ShapeRenderer shapeRenderer;

    private EntityManager entityManager;

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

        this.entityManager = EntityManager.initialize();
    }

    @Override
    public void show() {

    }

    private boolean paused = false;

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (paused) paused = false;
            else paused = true;
        }

        if (! paused) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            entityManager.render(spriteBatch, shapeRenderer);

            entityManager.update();

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