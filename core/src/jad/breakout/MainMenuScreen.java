package jad.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {

    private final OrthographicCamera camera;

    private final SpriteBatch spriteBatch;

    private final Texture texture;

    private final BreakoutGame breakoutGame;

    public MainMenuScreen(final BreakoutGame breakoutGame) {
        this.breakoutGame = breakoutGame;
        this.spriteBatch = breakoutGame.getBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800, 480);
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
                this.breakoutGame.getWIDTH() / 2,
                this.breakoutGame.getHEIGHT() / 2,
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
