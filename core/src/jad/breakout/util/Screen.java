package jad.breakout.util;

import jad.breakout.BreakoutGame;

public abstract class Screen implements com.badlogic.gdx.Screen {

    protected final BreakoutGame game;

    public Screen(final BreakoutGame game) {
        this.game = game;
    }
}
