package baseball.domain;

public class Baseball {

	private final int position;
	private final int number;

	public Baseball(int position, int number) {
		this.position = position;
		this.number = number;
	}

	public BaseballState compareTo(Baseball baseball) {
		if (number == baseball.number && position != baseball.position) {
			return BaseballState.BALL;
		}
		return BaseballState.NOTHING;
	}
}
