package baseball.exception;

public class InvalidBallCountException extends RuntimeException {

    private static final String MESSAGE = "볼 개수가 유효하지 않습니다. (현재: %d)";

    public InvalidBallCountException(int ballCount) {
        super(String.format(MESSAGE, ballCount));
    }
}
