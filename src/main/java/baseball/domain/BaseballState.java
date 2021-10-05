package baseball.domain;

public enum BaseballState {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isNothing() {
        return this == NOTHING;
    }
}
