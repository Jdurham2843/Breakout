package jad.breakout.util;

import java.util.List;

public class ScreenOptions {

    private final Class<? extends ExtendedScreen> screenClass;

    private final List<Integer> keys;

    public ScreenOptions(Class<? extends ExtendedScreen> screenClass, List<Integer> keys) {
        this.screenClass = screenClass;
        this.keys = keys;
    }

    public Class<? extends ExtendedScreen> getScreenClass() {
        return screenClass;
    }

    public List<Integer> getKeys() {
        return keys;
    }

}
