package baseball.domain;

import java.util.Objects;

public class Baseball {

    private final int number;

    public Baseball(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
