package baseball.view;

import baseball.domain.BaseballResult;

public class ResultView {

    private ResultView() {
    }

    public static void show(BaseballResult result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (result.isFinish()) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return;
        }
        if (result.hasStrike()) {
            System.out.print(result.strikeCount() + "스트라이크 ");
        }
        if (result.hasBall()) {
            System.out.print(result.ballCount() + "볼");
        }
        System.out.println();
    }
}
