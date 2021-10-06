package baseball.domain;

public class UserChoice {

    public static final String NEW_GAME = "1";
    public static final String GAME_OVER = "2";

    private final String choice;

    public UserChoice(String choice) {
        this.choice = choice;
    }

    public boolean isNewGame() {
        return choice.equals(NEW_GAME);
    }

    public boolean isGameOver() {
        return choice.equals(GAME_OVER);
    }

    public boolean isInvalid() {
        return !isNewGame() && !isGameOver();
    }
}
