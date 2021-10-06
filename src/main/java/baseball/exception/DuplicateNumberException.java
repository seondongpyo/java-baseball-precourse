package baseball.exception;

public class DuplicateNumberException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 중복된 숫자가 포함되어 있습니다.";

    public DuplicateNumberException() {
        super(MESSAGE);
    }
}
