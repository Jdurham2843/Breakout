package jad.breakout.util;

import com.badlogic.gdx.graphics.Texture;
import jad.breakout.BreakoutGame;

import java.util.Map;

public abstract class ExtendedScreen implements com.badlogic.gdx.Screen {

    protected final BreakoutGame game;

    protected Map<String, Texture> textures;

    public ExtendedScreen(final BreakoutGame game) {
        this.game = game;
    }

}
