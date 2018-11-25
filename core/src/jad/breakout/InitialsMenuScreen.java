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
        stateChangeKeys.add(Input.Keys.S);

        return stateChangeKeys;
    }

    public InitialsMenuScreen(final BreakoutApplication breakoutApplication) {
        super(breakoutApplication);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

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
                Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2,
                100,
                100);
        spriteBatch.end();

        if (this.game.getGuiStateMachine().shouldChangeState()) {
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