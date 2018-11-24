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
        screenMap.put(GuiState.MainMenu, new ScreenOptions(MainMenuScreen.class, MainMenuScreen.getStateChangeKeys()));
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

    public Screen determineScreen(final BreakoutGame game) throws Exception {
        final Constructor<?> constructor =
                this.screenMap.get(this.currentGuiState).getScreenClass().getConstructor(Screen.class);
        return (Screen) constructor.newInstance(game);
    }

    public GuiState getCurrentGuiState() {
        return currentGuiState;
    }
}
