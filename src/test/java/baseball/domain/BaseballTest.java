package baseball.domain;

import baseball.exception.InvalidBaseballNumberException;
import baseball.exception.InvalidBaseballPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    private final Baseball baseball = new Baseball(1, 1);

    @DisplayName("야구공의 숫자와 위치가 같으면 '스트라이크'이다.")
    @Test
    void strike() {
        BaseballState state = baseball.compareTo(new Baseball(1, 1));
        assertThat(state).isEqualTo(BaseballState.STRIKE);
    }

    @DisplayName("야구공의 숫자는 같지만 위치가 다르면 '볼'이다.")
    @Test
    void ball() {
        BaseballState state = baseball.compareTo(new Baseball(2, 1));
        assertThat(state).isEqualTo(BaseballState.BALL);
    }
    
    @DisplayName("야구공의 숫자가 일치하지 않으면 '낫싱'이다.")
    @Test
    void nothing() {
        BaseballState state = baseball.compareTo(new Baseball(2, 2));
        assertThat(state).isEqualTo(BaseballState.NOTHING);
    }

    @DisplayName("1 이상 9 이하의 숫자로 야구공을 생성한다.")
    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void validNumber(int number) {
        Baseball baseball = new Baseball(1, number);
        assertThat(baseball).isEqualTo(new Baseball(1, number));
    }

    @DisplayName("숫자가 1 이상 9 이하가 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 10})
    @ParameterizedTest
    void invalidNumber(int number) {
        assertThatThrownBy(() -> new Baseball(1, number))
            .isInstanceOf(InvalidBaseballNumberException.class);
    }

    @DisplayName("야구공은 1 이상 3 이하의 위치 값을 갖는다.")
    @ValueSource(ints = {1, 3})
    @ParameterizedTest
    void validPosition(int position) {
        Baseball baseball = new Baseball(position, 1);
        assertThat(baseball).isEqualTo(new Baseball(position, 1));
    }

    @DisplayName("위치 값이 1 이상 3 이하가 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 4})
    @ParameterizedTest
    void invalidPosition(int position) {
        assertThatThrownBy(() -> new Baseball(position, 1))
            .isInstanceOf(InvalidBaseballPositionException.class);
    }

}
