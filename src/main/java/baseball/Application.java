package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballPosition;
import baseball.domain.BaseballResult;
import baseball.domain.Baseballs;
import baseball.view.InputView;
import baseball.view.ResultView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Baseballs computerBaseballs = new Baseballs(createRandomNumbers());
        BaseballResult result = new BaseballResult();

        while (!result.isFinish()) {
            String numberText = InputView.numberText();
            Baseballs userBaseballs = new Baseballs(createNumbers(numberText));
            result = computerBaseballs.compareTo(userBaseballs);
            ResultView.show(result);
        }
    }

    private static List<Integer> createNumbers(String numberText) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : numberText.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        }
        return numbers;
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
