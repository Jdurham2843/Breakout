package jad.breakout.util;

import com.badlogic.gdx.graphics.Texture;
import jad.breakout.model.Breakout;

import java.util.Map;

public class BreakoutUtil {

    public static Breakout initializeBreakoutWorld(final Map<String, Texture> textures) {
        return new Breakout(null, null, null);
    }

    public static Breakout resetWorld(final Breakout breakout) {

        return new Breakout(null, null, null);
    }
}
