package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballsTest {

    @DisplayName("3개의 숫자로 야구공 묶음을 생성한다.")
    @Test
    void create() {
        Baseballs baseballs = new Baseballs(Arrays.asList(1, 2, 3));
        assertThat(baseballs).isEqualTo(new Baseballs(Arrays.asList(1, 2, 3)));
    }

}
