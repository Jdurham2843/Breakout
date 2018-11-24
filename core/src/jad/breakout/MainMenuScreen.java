package jad.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jad.breakout.util.ExtendedScreen;
import jad.breakout.util.ScreenOptions;

import java.util.ArrayList;
import java.util.List;

public class MainMenuScreen extends ExtendedScreen {

    private final OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    private final Texture texture;

    public static ScreenOptions getScreenOptions() {
        return new ScreenOptions(MainMenuScreen.class, MainMenuScreen.getStateChangeKeys());
    }

    private static List<Integer> getStateChangeKeys() {
        final List<Integer> stateChangeKeys = new ArrayList<>();
        stateChangeKeys.add(Input.Keys.ANY_KEY);

        return stateChangeKeys;
    }

    public MainMenuScreen(final BreakoutGame breakoutGame) {
        super(breakoutGame);
        this.spriteBatch = breakoutGame.getSpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, breakoutGame.getWIDTH(), breakoutGame.getHEIGHT());
        this.texture = breakoutGame.getImg();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.camera.update();

        this.spriteBatch.setProjectionMatrix(this.camera.combined);
        this.spriteBatch.begin();
        this.spriteBatch.draw(
                   this.texture,
                this.game.getWIDTH() / 2,
                this.game.getHEIGHT() / 2,
                100,
                100);
        this.spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

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
