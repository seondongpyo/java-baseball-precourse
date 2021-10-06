package baseball.utils;

import baseball.domain.Baseballs;
import baseball.domain.UserChoice;
import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberTextException;
import baseball.exception.InvalidUserChoiceException;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    private static final String REGEX_FOR_THREE_DIGIT_NUMBER = "[1-9]{3}";

    private ValidationUtils() {
    }

    public static void validateIfValidAsBaseballNumber(String text) {
        if (isNotThreeDigitNumber(text)) {
            throw new InvalidNumberTextException();
        }
        if (hasDuplicateNumber(text)) {
            throw new DuplicateNumberException();
        }
    }

    public static void validateIfValidAsUserChoice(String text) {
        UserChoice choice = new UserChoice(text);
        if (choice.isInvalid()) {
            throw new InvalidUserChoiceException();
        }
    }

    private static boolean isNotThreeDigitNumber(String text) {
        return !text.matches(REGEX_FOR_THREE_DIGIT_NUMBER);
    }

    private static boolean hasDuplicateNumber(String text) {
        Set<Integer> numbers = new HashSet<>();
        for (char number : text.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        }
        return numbers.size() != Baseballs.VALID_SIZE;
    }
}
