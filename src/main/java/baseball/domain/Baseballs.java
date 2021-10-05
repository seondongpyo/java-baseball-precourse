package baseball.domain;

import baseball.exception.InvalidBaseballsSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.domain.BaseballPosition.MAX_VALUE;
import static baseball.domain.BaseballPosition.MIN_VALUE;
import static baseball.domain.BaseballState.NOTHING;

public class Baseballs {

    private static final int VALID_SIZE = 3;

    private final List<Baseball> baseballs;

    public Baseballs(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        this.baseballs = createBaseballs(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        int sizeOfNumbers = numbers.size();
        if (sizeOfNumbers != VALID_SIZE) {
            throw new InvalidBaseballsSizeException(sizeOfNumbers);
        }
    }

    private List<Baseball> createBaseballs(List<Integer> numbers) {
        List<Baseball> baseballs = new ArrayList<>();
        for (int position = MIN_VALUE; position <= MAX_VALUE; position++) {
            baseballs.add(new Baseball(position, numbers.get(position - 1)));
        }
        return baseballs;
    }

    public BaseballState compareTo(Baseball target) {
        BaseballState state = NOTHING;
        int position = MIN_VALUE;
        while (state.isNothing() && position <= MAX_VALUE) {
            Baseball currentBaseball = baseballs.get(position - 1);
            state = currentBaseball.compareTo(target);
            position++;
        }
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseballs baseballs1 = (Baseballs) o;
        return Objects.equals(baseballs, baseballs1.baseballs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs);
    }
}
