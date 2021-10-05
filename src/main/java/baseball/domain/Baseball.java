package baseball.domain;

import java.util.Objects;

public class Baseball {

    private final BaseballNumber number;
    private final BaseballPosition position;

    public Baseball(int number, int position) {
        this.number = new BaseballNumber(number);
        this.position = new BaseballPosition(position);
    }

    public BaseballState compareTo(Baseball baseball) {
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
        return Objects.equals(number, baseball.number) && Objects.equals(position, baseball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
