package baseball.domain;

import baseball.exception.InvalidBallCountException;
import baseball.exception.InvalidBaseballResultException;
import baseball.exception.InvalidStrikeCountException;

public class BaseballResult {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static final int COUNT_ONE = 1;
    private static final int COUNT_TWO = 2;

    private int strikeCount;
    private int ballCount;

    public BaseballResult() {
        this(0, 0);
    }

    public BaseballResult(int strikeCount, int ballCount) {
        validateStrikeBallCounts(strikeCount, ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
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

    private void validateStrikeBallCounts(int strikeCount, int ballCount) {
        if (isInvalidCount(strikeCount)) {
            throw new InvalidStrikeCountException(strikeCount);
        }
        if (isInvalidCount(ballCount)) {
            throw new InvalidBallCountException(ballCount);
        }
        if (isInvalidResultBy(strikeCount, ballCount)) {
            throw new InvalidBaseballResultException(strikeCount, ballCount);
        }
    }

    private boolean isInvalidResultBy(int strikeCount, int ballCount) {
        return (strikeCount + ballCount > MAX_COUNT) || (strikeCount == COUNT_TWO && ballCount == COUNT_ONE);
    }

    private boolean isInvalidCount(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
    }
}
