package jad.breakout;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jad.breakout.util.GuiStateMachine;

public class BreakoutApplication extends Game {

	private SpriteBatch spriteBatch;

	private final GuiStateMachine guiStateMachine;

	public BreakoutApplication() {
	    this.guiStateMachine = new GuiStateMachine();
    }
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();

        this.guiStateMachine.determineScreen(this);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public GuiStateMachine getGuiStateMachine() {
        return guiStateMachine;
    }
}
