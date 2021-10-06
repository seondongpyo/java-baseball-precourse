package baseball.domain;

import baseball.exception.InvalidUserChoiceException;

public class UserChoice {

    public static final String NEW_GAME = "1";
    public static final String GAME_OVER = "2";

    private final String choice;

    public UserChoice(String choice) {
        validateChoice(choice);
        this.choice = choice;
    }

    private void validateChoice(String choice) {
        if (isInvalid(choice)) {
            throw new InvalidUserChoiceException();
        }
    }

    public boolean isNewGame() {
        return choice.equals(NEW_GAME);
    }

    public boolean isGameOver() {
        return choice.equals(GAME_OVER);
    }

    private boolean isInvalid(String inputValue) {
        return !inputValue.equals(NEW_GAME) && !inputValue.equals(GAME_OVER);
    }
}
