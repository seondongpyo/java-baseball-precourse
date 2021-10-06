package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballPosition;
import baseball.domain.Baseballs;
import baseball.view.InputView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> computerNumbers = createRandomNumbers();
        Baseballs computerBaseballs = new Baseballs(computerNumbers);
        String numberText = InputView.numberText();
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BaseballPosition.MAX_VALUE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballNumber.MIN_VALUE, BaseballNumber.MAX_VALUE);
            addNumberIfNotDuplicate(numbers, randomNumber);
        }
        return numbers;
    }

    private static void addNumberIfNotDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }

}
