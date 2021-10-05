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
