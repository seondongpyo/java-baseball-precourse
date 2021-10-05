package baseball.domain;

import baseball.exception.InvalidBaseballPositionException;

import java.util.Objects;

public class BaseballPosition {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3;

    private final int value;

    public BaseballPosition(int value) {
        validatePositionValue(value);
        this.value = value;
    }

    private void validatePositionValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidBaseballPositionException(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballPosition position = (BaseballPosition) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
