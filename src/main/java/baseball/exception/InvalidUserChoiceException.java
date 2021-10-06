package baseball.exception;

public class InvalidUserChoiceException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 유효하지 않은 입력값입니다.";

    public InvalidUserChoiceException() {
        super(MESSAGE);
    }
}
