package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;

import java.util.Objects;

public class BaseballNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    public BaseballNumber(int value) {
        validateNumberValue(value);
        this.value = value;
    }

    private void validateNumberValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidBaseballNumberException(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
