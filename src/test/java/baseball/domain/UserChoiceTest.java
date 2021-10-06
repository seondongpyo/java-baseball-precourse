package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserChoiceTest {

    @DisplayName("새로운 게임 시작")
    @Test
    void newGame() {
        UserChoice choice = new UserChoice("1");
        assertThat(choice.isNewGame()).isTrue();
    }

    @DisplayName("게임 종료")
    @Test
    void gameOver() {
        UserChoice choice = new UserChoice("2");
        assertThat(choice.isGameOver()).isTrue();
    }

    @DisplayName("유효하지 않은 입력값")
    @ValueSource(strings = {"12", "3", "x", "!", "끝"})
    @ParameterizedTest
    void invalid(String inputValue) {
        UserChoice choice = new UserChoice(inputValue);
        assertThat(choice.isInvalid()).isTrue();
    }

}