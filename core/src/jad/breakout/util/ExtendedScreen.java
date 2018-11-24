package jad.breakout.util;

import jad.breakout.BreakoutGame;

public abstract class ExtendedScreen implements com.badlogic.gdx.Screen {

    protected final BreakoutGame game;

    public ExtendedScreen(final BreakoutGame game) {
        this.game = game;
    }

}
