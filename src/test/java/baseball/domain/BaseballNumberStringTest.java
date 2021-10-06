package baseball.domain;

import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberTextException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberStringTest {

    @DisplayName("문자열이 1 이상 9 이하의 숫자로 구성된 중복되지 않은 3자리 숫자인지 검증한다.")
    @ValueSource(strings = {"123", "456", "789"})
    @ParameterizedTest
    void valid(String text) {
        assertThatNoException()
            .isThrownBy(() -> BaseballNumberString.from(text));
    }

    @DisplayName("문자열 검증 결과 유효한 숫자 문자열이 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"012", "890", "12", "1234", "x12", "1!2", "12/"})
    @ParameterizedTest
    void invalid(String text) {
        assertThatThrownBy(() -> BaseballNumberString.from(text))
            .isInstanceOf(InvalidNumberTextException.class);
    }

    @DisplayName("문자열 검증 결과 중복된 숫자가 포함된 경우 예외가 발생한다.")
    @ValueSource(strings = {"112", "343"})
    @ParameterizedTest
    void duplicate(String text) {
        assertThatThrownBy(() -> BaseballNumberString.from(text))
            .isInstanceOf(DuplicateNumberException.class);
    }

}