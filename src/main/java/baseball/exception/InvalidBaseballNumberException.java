package baseball.exception;

public class InvalidBaseballNumberException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 유효하지 않은 숫자입니다. (현재: %d)";

    public InvalidBaseballNumberException(int number) {
        super(String.format(MESSAGE, number));
    }
}
