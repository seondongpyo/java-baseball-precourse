package baseball.view;

import baseball.domain.UserChoice;
import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

public class InputView {

    private static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static String numberText() {
        System.out.print(MESSAGE_INPUT_NUMBERS);
        String text = Console.readLine();
        try {
            ValidationUtils.validateIfValidAsBaseballNumber(text);
            return text;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return numberText();
        }
    }

    public static UserChoice restartOrQuit() {
        System.out.println(MESSAGE_RESTART_OR_QUIT);
        String text = Console.readLine();
        try {
            return new UserChoice(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return restartOrQuit();
        }
    }
}
