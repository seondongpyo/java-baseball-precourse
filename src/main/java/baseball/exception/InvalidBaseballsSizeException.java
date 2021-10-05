package baseball.exception;

public class InvalidBaseballsSizeException extends RuntimeException {

    private static final String MESSAGE = "야구공 묶음은 3개의 숫자로만 생성할 수 있습니다. (입력한 숫자의 수: %d)";

    public InvalidBaseballsSizeException(int size) {
        super(String.format(MESSAGE, size));
    }
}
