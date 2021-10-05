package baseball.domain;

import java.util.Objects;

public class Baseball {

    private final BaseballPosition position;
    private final BaseballNumber number;

    public Baseball(int position, int number) {
        this.position = new BaseballPosition(position);
        this.number = new BaseballNumber(number);
    }

    public BaseballState compareTo(Baseball baseball) {
        if (this.equals(baseball)) {
            return BaseballState.STRIKE;
        }
        if (number.equals(baseball.number)) {
            return BaseballState.BALL;
        }
        return BaseballState.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return Objects.equals(position, baseball.position) && Objects.equals(number, baseball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
