package baseball;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.ResultView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        do {
            playNewGame();
        } while (!isGameOver());
    }

    private static void playNewGame() {
        Baseballs computerBaseballs = new Baseballs(createRandomNumbers());
        BaseballResult result = new BaseballResult();

        while (!result.isFinish()) {
            BaseballNumberString numberString = InputView.numberString();
            Baseballs userBaseballs = new Baseballs(numberString.toNumbers());
            result = computerBaseballs.compareTo(userBaseballs);
            ResultView.show(result);
        }
    }

    private static boolean isGameOver() {
        UserChoice choice = InputView.restartOrQuit();
        return choice.isGameOver();
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Baseballs.VALID_SIZE) {
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
