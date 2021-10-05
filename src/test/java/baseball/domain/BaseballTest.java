package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @DisplayName("1 이상 9 이하의 숫자로 야구공을 생성한다.")
    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void create(int number) {
        Baseball baseball = new Baseball(number);
        assertThat(baseball).isEqualTo(new Baseball(number));
    }

}
