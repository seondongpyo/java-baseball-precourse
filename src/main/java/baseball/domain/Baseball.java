package baseball.domain;

import baseball.exception.InvalidBaseballPositionException;

import java.util.Objects;

public class Baseball {

    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;

    private final BaseballNumber number;
    private final int position;

    public Baseball(int number, int position) {
        validateBaseballPosition(position);
        this.number = new BaseballNumber(number);
        this.position = position;
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
        return position == baseball.position && Objects.equals(number, baseball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
