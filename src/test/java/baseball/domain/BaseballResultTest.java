package baseball.domain;

import baseball.exception.InvalidBaseballResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballResultTest {

    @DisplayName("숫자 야구 게임 결과 생성 시 예외 - 스트라이크의 개수는 0개 이상 3개 이하까지만 가능하다.")
    @ValueSource(ints = {-1, 4})
    @ParameterizedTest
    void invalid_strike_count(int strikeCount) {
        assertThatThrownBy(() -> new BaseballResult(strikeCount, 0))
            .isInstanceOf(InvalidBaseballResultException.class);
    }


}