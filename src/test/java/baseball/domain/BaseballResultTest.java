package baseball.domain;

import baseball.exception.InvalidBaseballResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballResultTest {

    @DisplayName("숫자 야구 게임 결과 생성 시 예외 - 스트라이크의 개수는 0개 이상 3개 이하까지만 가능하다.")
    @ValueSource(ints = {-1, 4})
    @ParameterizedTest
    void invalid_strike_count(int strikeCount) {
        assertThatThrownBy(() -> new BaseballResult(strikeCount, 0))
            .isInstanceOf(InvalidBaseballResultException.class);
    }

    @DisplayName("숫자 야구 게임 결과 생성 시 예외 - 볼의 개수는 0개 이상 3개 이하까지만 가능하다.")
    @ValueSource(ints = {-1, 4})
    @ParameterizedTest
    void invalid_ball_count(int ballCount) {
        assertThatThrownBy(() -> new BaseballResult(0, ballCount))
            .isInstanceOf(InvalidBaseballResultException.class);
    }

    @DisplayName("숫자 야구 게임 결과 생성 시 예외 - 스트라이크와 볼의 개수의 합은 최대 3까지만 가능하다.")
    @MethodSource("argumentsForInvalidTotalCounts")
    @ParameterizedTest
    void invalid_total_counts(int strikeCount, int ballCount) {
        assertThatThrownBy(() -> new BaseballResult(strikeCount, ballCount))
            .isInstanceOf(InvalidBaseballResultException.class);
    }

    private static Stream<Arguments> argumentsForInvalidTotalCounts() {
        return Stream.of(
            Arguments.of(1, 3), Arguments.of(2, 2), Arguments.of(3, 1)
        );
    }
}