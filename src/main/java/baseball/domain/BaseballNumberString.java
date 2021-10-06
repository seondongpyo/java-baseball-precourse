package baseball.domain;

import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberTextException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberString {

    private static final String REGEX_FOR_THREE_DIGIT_NUMBER = "[1-9]{3}";

    private final String numberString;

    private BaseballNumberString(String numberString) {
        this.numberString = numberString;
    }

    public static BaseballNumberString from(String inputValue) {
        if (isNotThreeDigitNumber(inputValue)) {
            throw new InvalidNumberTextException();
        }
        if (hasDuplicateNumber(inputValue)) {
            throw new DuplicateNumberException();
        }
        return new BaseballNumberString(inputValue);
    }

    private static boolean isNotThreeDigitNumber(String inputValue) {
        return !inputValue.matches(REGEX_FOR_THREE_DIGIT_NUMBER);
    }

    private static boolean hasDuplicateNumber(String inputValue) {
        Set<Integer> numbers = new HashSet<>();
        for (char number : inputValue.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        }
        return numbers.size() != Baseballs.VALID_SIZE;
    }

    public List<Integer> toNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (char number : numberString.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        }
        return numbers;
    }
}
