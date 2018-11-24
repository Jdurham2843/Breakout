package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import jad.breakout.BreakoutGame;
import jad.breakout.GuiState;
import jad.breakout.MainMenuScreen;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class GuiStateMachine {

    private GuiState currentGuiState;

    private static final Map<GuiState, ScreenOptions> screenMap = new HashMap<>();

    static {
        screenMap.put(GuiState.MainMenu, MainMenuScreen.getScreenOptions());
        screenMap.put(GuiState.InitialsMenu, null);
        screenMap.put(GuiState.GameScreen, null);
        screenMap.put(GuiState.PauseScreen, null);
    }

    public GuiStateMachine() {
        this.currentGuiState = GuiState.MainMenu;
    }

    public boolean shouldChangeState() {
        return screenMap.get(this.currentGuiState).getKeys().stream()
                .anyMatch(key -> Gdx.input.isButtonPressed(key));
    }

    public ExtendedScreen determineScreen(final BreakoutGame game) throws Exception {
        final ScreenOptions screenOptions = this.screenMap.get(this.currentGuiState);

        final Constructor<?> constructor =
                screenOptions.getScreenClass().getConstructor(game.getClass());
        return (ExtendedScreen) constructor.newInstance(game);
    }

    public GuiState getCurrentGuiState() {
        return currentGuiState;
    }
}
