package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;
import baseball.exception.InvalidBaseballPositionException;

import java.util.Objects;

public class Baseball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;

    private final int number;
    private final int position;

    public Baseball(int number, int position) {
        validateBaseballNumber(number);
        validateBaseballPosition(position);
        this.position = position;
        this.number = number;
    }

    private void validateBaseballNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidBaseballNumberException(number);
        }
    }

    private void validateBaseballPosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new InvalidBaseballPositionException(position);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return number == baseball.number && position == baseball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
