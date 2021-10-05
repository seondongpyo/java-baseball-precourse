package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;

import java.util.Objects;

public class Baseball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;
    private final int position;

    public Baseball(int number, int position) {
        validateBaseballNumber(number);
        this.position = position;
        this.number = number;
    }

    private void validateBaseballNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidBaseballNumberException(number);
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
