package jad.breakout;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jad.breakout.util.GuiStateMachine;

public class BreakoutGame extends Game {
    private final int WIDTH;
    private final int HEIGHT;

	private SpriteBatch spriteBatch;
	private Texture img;

	private final GuiStateMachine guiStateMachine;

	public BreakoutGame(final int width, final int height) {
	    this.HEIGHT = height;
	    this.WIDTH = width;
	    this.guiStateMachine = new GuiStateMachine();
    }
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("badlogic.jpg"));
		this.screen = new MainMenuScreen(this);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		img.dispose();
	}

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Texture getImg() {
        return img;
    }

}
