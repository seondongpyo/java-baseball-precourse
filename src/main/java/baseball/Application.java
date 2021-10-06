package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballPosition;
import baseball.domain.Baseballs;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> computerBaseballNumbers = createRandomBaseballNumbers();
        Baseballs computerBaseballs = new Baseballs(computerBaseballNumbers);
    }

    private static List<Integer> createRandomBaseballNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < BaseballPosition.MAX_VALUE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballNumber.MIN_VALUE, BaseballNumber.MAX_VALUE);
            addNumberIfNotDuplicate(baseballNumbers, randomNumber);
        }
        return baseballNumbers;
    }

    private static void addNumberIfNotDuplicate(List<Integer> baseballNumbers, int number) {
        if (baseballNumbers.contains(number)) {
            return;
        }
        baseballNumbers.add(number);
    }

}
