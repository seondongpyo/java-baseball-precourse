package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("1 이상 9 이하의 값으로 야구공의 숫자를 생성한다.")
    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void valid(int value) {
        BaseballNumber baseballNumber = new BaseballNumber(value);
        assertThat(baseballNumber).isEqualTo(new BaseballNumber(value));
    }

    @DisplayName("값이 1 이상 9 이하가 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 10})
    @ParameterizedTest
    void invalid(int value) {
        assertThatThrownBy(() -> new BaseballNumber(value))
            .isInstanceOf(InvalidBaseballNumberException.class);
    }

}
