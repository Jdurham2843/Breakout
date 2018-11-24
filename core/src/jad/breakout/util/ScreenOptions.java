package jad.breakout.util;

import java.util.List;

public class ScreenOptions {

    private final Class<? extends Screen> screenClass;

    private final List<Integer> keys;

    public ScreenOptions(Class<? extends Screen> screenClass, List<Integer> keys) {
        this.screenClass = screenClass;
        this.keys = keys;
    }

    public Class<? extends Screen> getScreenClass() {
        return screenClass;
    }

    public List<Integer> getKeys() {
        return keys;
    }

}
