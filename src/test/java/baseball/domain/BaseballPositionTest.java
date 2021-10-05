package baseball.domain;

import baseball.exception.InvalidBaseballPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballPositionTest {

    @DisplayName("1 이상 3 이하의 숫자로 야구공의 위치 값을 생성한다.")
    @ValueSource(ints = {1, 3})
    @ParameterizedTest
    void valid(int value) {
        BaseballPosition baseballPosition = new BaseballPosition(value);
        assertThat(baseballPosition).isEqualTo(new BaseballPosition(value));
    }

    @DisplayName("위치 값이 1 이상 3 이하가 아닌 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 4})
    @ParameterizedTest
    void invalid(int value) {
        assertThatThrownBy(() -> new BaseballPosition(value))
            .isInstanceOf(InvalidBaseballPositionException.class);
    }
}
