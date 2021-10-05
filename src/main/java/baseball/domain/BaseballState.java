package baseball.domain;

public enum BaseballState {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
