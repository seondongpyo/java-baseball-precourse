package baseball.domain;

public class BaseballResult {

    private int strikeCount;
    private int ballCount;

    public void add(BaseballState state) {
        if (state.isStrike()) {
            strikeCount++;
        }
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
