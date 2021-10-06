package baseball.view;

import baseball.domain.BaseballResult;

public class ResultView {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    private ResultView() {
    }

    public static void show(BaseballResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        printStrikeBallCount(result);
        if (result.isFinish()) {
            System.out.println(GAME_OVER);
        }
    }

    private static void printStrikeBallCount(BaseballResult result) {
        if (result.hasStrike()) {
            System.out.printf("%d%s ", result.strikeCount(), STRIKE);
        }
        if (result.hasBall()) {
            System.out.printf("%d%s", result.ballCount(), BALL);
        }
        System.out.println();
    }
}
