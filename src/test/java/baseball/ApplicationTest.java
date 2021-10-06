package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void strike1_ball2() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("153");
            verify("1스트라이크 2볼");
        }
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void strike1_ball1() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("154");
            verify("1스트라이크 1볼");
        }
    }

    @DisplayName("3스트라이크")
    @Test
    void strike3() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("135");
            verify("3스트라이크");
        }
    }

    @DisplayName("2스트라이크")
    @Test
    void strike2() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("134");
            verify("2스트라이크");
        }
    }

    @DisplayName("1스트라이크")
    @Test
    void strike1() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("146");
            verify("1스트라이크");
        }
    }

    @DisplayName("3볼")
    @Test
    void ball3() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("513");
            verify("3볼");
        }
    }

    @DisplayName("2볼")
    @Test
    void ball2() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("413");
            verify("2볼");
        }
    }

    @DisplayName("1볼")
    @Test
    void ball1() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("416");
            verify("1볼");
        }
    }

    @DisplayName("사용자가 게임 재개 여부 선택 시 잘못된 숫자를 입력할 경우 예외 발생")
    @ValueSource(strings = {"3", "x", "!"})
    @ParameterizedTest
    void invalidChoice(String inputValue) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("135", inputValue);
            verify("[ERROR] 유효하지 않은 입력값입니다.");
        }
    }

    @DisplayName("사용자가 잘못된 숫자를 입력할 경우 예외 발생")
    @ValueSource(strings = {"1", "12", "012", "1234", "x12", "3*!"})
    @ParameterizedTest
    void invalidNumber(String inputValue) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running(inputValue);
            verify("[ERROR] 유효한 3자리 숫자가 아닙니다.");
        }
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
