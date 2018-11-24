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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialsMenuScreen extends ExtendedScreen {

    private final OrthographicCamera camera;

    public static ScreenOptions getScreenOptions() {
        return new ScreenOptions(InitialsMenuScreen.class, InitialsMenuScreen.getStateChangeKeys());
    }

    private static List<Integer> getStateChangeKeys() {
        final List<Integer> stateChangeKeys = new ArrayList<>();
        stateChangeKeys.add(Input.Keys.W);

        return stateChangeKeys;
    }

    public InitialsMenuScreen(final BreakoutGame breakoutGame) {
        super(breakoutGame);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, breakoutGame.getWIDTH(), breakoutGame.getHEIGHT());

        this.textures = this.initializeTextures();
    }

    protected Map<String, Texture> initializeTextures() {
        final Map<String, Texture> textures = new HashMap<>();
        textures.put("badLogic", new Texture(Gdx.files.internal("badlogic.jpg")));

        return textures;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.camera.update();

        final SpriteBatch spriteBatch = this.game.getSpriteBatch();
        final Texture texture = this.textures.get("badLogic");

        spriteBatch.setProjectionMatrix(this.camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(
                texture,
                this.game.getWIDTH() / 2,
                this.game.getHEIGHT() / 2,
                100,
                100);
        spriteBatch.end();

        if (Gdx.input.isTouched()) {
            this.game.getGuiStateMachine().determineScreen(this.game);
        }
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
        this.textures.entrySet().forEach(es -> {
            es.getValue().dispose();
        });
    }
}