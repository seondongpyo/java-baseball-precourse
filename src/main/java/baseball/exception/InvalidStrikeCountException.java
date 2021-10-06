package baseball.exception;

public class InvalidStrikeCountException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 스트라이크 개수가 유효하지 않습니다. (현재: %d)";

    public InvalidStrikeCountException(int strikeCount) {
        super(String.format(MESSAGE, strikeCount));
    }
}
