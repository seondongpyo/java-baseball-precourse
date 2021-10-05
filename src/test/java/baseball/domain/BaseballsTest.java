package baseball.domain;

import baseball.exception.InvalidBaseballsSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballsTest {

    private final Baseballs baseballs = new Baseballs(Arrays.asList(1, 2, 3));

    @DisplayName("2스트라이크")
    @Test
    void strike2() {
        BaseballResult result = baseballs.compareTo(new Baseballs(Arrays.asList(1, 2, 4)));
        assertThat(result.strikeCount()).isEqualTo(2);
        assertThat(result.ballCount()).isZero();
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void strike1_ball2() {
        BaseballResult result = baseballs.compareTo(new Baseballs(Arrays.asList(1, 3, 2)));
        assertThat(result.strikeCount()).isEqualTo(1);
        assertThat(result.ballCount()).isEqualTo(2);
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void strike1_ball1() {
        BaseballResult result = baseballs.compareTo(new Baseballs(Arrays.asList(1, 3, 4)));
        assertThat(result.strikeCount()).isEqualTo(1);
        assertThat(result.ballCount()).isEqualTo(1);
    }
    
    @DisplayName("1스트라이크")
    @Test
    void strike1() {
        BaseballResult result = baseballs.compareTo(new Baseballs(Arrays.asList(1, 4, 5)));
        assertThat(result.strikeCount()).isEqualTo(1);
        assertThat(result.ballCount()).isZero();
    }

    @DisplayName("야구공 묶음 안에 전달한 야구공의 숫자와 위치가 모두 일치하는 야구공이 존재하면 '스트라이크'이다.")
    @Test
    void strike() {
        BaseballState state = baseballs.compareTo(new Baseball(1, 1));
        assertThat(state).isEqualTo(BaseballState.STRIKE);
    }

    @DisplayName("야구공 묶음 안에 전달한 야구공의 숫자와 일치하지만 위치가 다른 야구공이 존재하면 '볼'이다.")
    @Test
    void ball() {
        BaseballState state = baseballs.compareTo(new Baseball(2, 1));
        assertThat(state).isEqualTo(BaseballState.BALL);
    }

    @DisplayName("야구공 묶음 안에 전달한 야구공의 숫자와 일치하는 야구공이 존재하지 않으면 '낫싱'이다.")
    @Test
    void nothing() {
        BaseballState state = baseballs.compareTo(new Baseball(1, 4));
        assertThat(state).isEqualTo(BaseballState.NOTHING);
    }

    @DisplayName("3개의 숫자로 야구공 묶음을 생성한다.")
    @Test
    void create() {
        Baseballs baseballs = new Baseballs(Arrays.asList(1, 2, 3));
        assertThat(baseballs).isEqualTo(new Baseballs(Arrays.asList(1, 2, 3)));
    }

    @DisplayName("야구공 묶음 생성 시 숫자의 개수가 3개가 아니라면 예외가 발생한다.")
    @MethodSource("argumentsForInvalid")
    @ParameterizedTest
    void invalid(List<Integer> numbers) {
        assertThatThrownBy(() -> new Baseballs(numbers))
            .isInstanceOf(InvalidBaseballsSizeException.class);
    }

    private static Stream<Arguments> argumentsForInvalid() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2)),
            Arguments.of(Arrays.asList(1, 2, 3, 4))
        );
    }

}
