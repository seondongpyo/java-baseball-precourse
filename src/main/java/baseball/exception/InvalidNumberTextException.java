package baseball.exception;

public class InvalidNumberTextException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 유효한 3자리 숫자가 아닙니다.";

    public InvalidNumberTextException() {
        super(MESSAGE);
    }

}
