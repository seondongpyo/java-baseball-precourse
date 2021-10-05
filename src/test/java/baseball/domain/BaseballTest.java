package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    @DisplayName("1 이상 9 이하의 숫자로 야구공을 생성한다.")
    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void create(int number) {
        Baseball baseball = new Baseball(number);
        assertThat(baseball).isEqualTo(new Baseball(number));
    }

    @DisplayName("숫자가 1 이상 9 이하가 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 10})
    @ParameterizedTest
    void invalid(int number) {
        assertThatThrownBy(() -> new Baseball(number))
            .isInstanceOf(InvalidBaseballNumberException.class);
    }

}
