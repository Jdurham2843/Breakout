package jad.breakout.util;

import com.badlogic.gdx.graphics.Texture;
import jad.breakout.BreakoutApplication;

import java.util.Map;

public abstract class ExtendedScreen implements com.badlogic.gdx.Screen {

    protected final BreakoutApplication game;

    protected Map<String, Texture> textures;

    public ExtendedScreen(final BreakoutApplication game) {
        this.game = game;
    }

}
