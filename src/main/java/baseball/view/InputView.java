package baseball.view;

import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

public class InputView {

    private static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";

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

}
