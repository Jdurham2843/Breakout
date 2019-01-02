package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import jad.breakout.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class GuiStateMachine {

    private GuiState currentGuiState;

    private static final Map<GuiState, ScreenOptions> screenMap = new HashMap<>();

    static {
        screenMap.put(GuiState.MainMenu, MainMenuScreen.getScreenOptions());
        screenMap.put(GuiState.InitialsMenu, InitialsMenuScreen.getScreenOptions());
        screenMap.put(GuiState.GameScreen, GameScreen.getScreenOptions());
        screenMap.put(GuiState.PauseScreen, null);
    }

    public GuiStateMachine() {
        this.currentGuiState = GuiState.MainMenu;
    }

    public boolean shouldChangeState() {
        return screenMap.get(this.currentGuiState).getKeys().stream()
                .anyMatch(key -> Gdx.input.isKeyPressed(key));
    }

    public void determineScreen(final BreakoutApplication game)  {
        switch (this.currentGuiState) {
            case MainMenu:
                this.currentGuiState = GuiState.InitialsMenu;
                break;
            case InitialsMenu:
                this.currentGuiState = GuiState.GameScreen;
                break;
        }

        final ScreenOptions screenOptions = screenMap.get(this.currentGuiState);

        try {
            final Constructor<?> constructor =
                    screenOptions.getScreenClass().getConstructor(game.getClass());

            final ExtendedScreen screen = (ExtendedScreen) constructor.newInstance(game);
            game.setScreen(screen);
        } catch (Exception e) {

        }
    }

    public GuiState getCurrentGuiState() {
        return currentGuiState;
    }
}
