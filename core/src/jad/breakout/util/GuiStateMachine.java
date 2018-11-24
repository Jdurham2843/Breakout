package jad.breakout.util;

import com.badlogic.gdx.Gdx;
import jad.breakout.BreakoutGame;
import jad.breakout.GuiState;
import jad.breakout.InitialsMenuScreen;
import jad.breakout.MainMenuScreen;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class GuiStateMachine {

    private GuiState currentGuiState;

    private static final Map<GuiState, ScreenOptions> screenMap = new HashMap<>();

    static {
        screenMap.put(GuiState.MainMenu, MainMenuScreen.getScreenOptions());
        screenMap.put(GuiState.InitialsMenu, InitialsMenuScreen.getScreenOptions());
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

    public ExtendedScreen determineScreen(final BreakoutGame game)  {
        if (true) {
            switch (this.currentGuiState) {
                case MainMenu:
                    this.currentGuiState = GuiState.InitialsMenu;
                    break;
                case InitialsMenu:
                    this.currentGuiState = GuiState.MainMenu;
                    break;
            }
        }

        final ScreenOptions screenOptions = screenMap.get(this.currentGuiState);

        try {
            final Constructor<?> constructor =
                    screenOptions.getScreenClass().getConstructor(game.getClass());
            return (ExtendedScreen) constructor.newInstance(game);
        } catch (Exception e) {
            return null;
        }
    }

    public GuiState getCurrentGuiState() {
        return currentGuiState;
    }
}
