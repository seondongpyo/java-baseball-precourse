package baseball.exception;

public class InvalidBaseballPositionException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 유효하지 않은 위치 값입니다. (현재: %d)";

    public InvalidBaseballPositionException(int position) {
        super(String.format(MESSAGE, position));
    }
}
