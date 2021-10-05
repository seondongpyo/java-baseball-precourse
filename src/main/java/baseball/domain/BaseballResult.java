package baseball.domain;

import baseball.exception.InvalidBaseballResultException;

public class BaseballResult {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;

    private int strikeCount;
    private int ballCount;

    public BaseballResult() {
        this(0, 0);
    }

    public BaseballResult(int strikeCount, int ballCount) {
        if (isInvalid(strikeCount) || isInvalid(ballCount) || isInvalidTotalCounts(strikeCount, ballCount)) {
            throw new InvalidBaseballResultException(strikeCount, ballCount);
        }
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private boolean isInvalidTotalCounts(int strikeCount, int ballCount) {
        return strikeCount + ballCount > MAX_COUNT;
    }

    private boolean isInvalid(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
    }

    public void add(BaseballState state) {
        if (state.isStrike()) {
            strikeCount++;
        }
        if (state.isBall()) {
            ballCount++;
        }
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
