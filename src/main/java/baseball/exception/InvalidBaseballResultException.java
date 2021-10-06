package baseball.exception;

public class InvalidBaseballResultException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 유효하지 않은 게임 결과입니다. (현재: 스트라이크(%d), 볼(%d))";

    public InvalidBaseballResultException(int strikeCount, int ballCount) {
        super(String.format(MESSAGE, strikeCount, ballCount));
    }
}
