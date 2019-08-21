package jad.breakout.util;

import com.badlogic.gdx.Gdx;

public class DimensionHelper {

    public static int totalHeight() {
        return Gdx.graphics.getHeight();
    }

    public static int totalWidth() {
        return Gdx.graphics.getWidth();
    }

    public static int playAreaHeight() {
        return totalHeight();
    }

    public static int playAreaWidth() {
        return totalWidth();
    }
}
