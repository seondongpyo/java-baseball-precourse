package baseball.domain;

import java.util.Objects;

public class Baseball {

	private final int position;
	private final int number;

	public Baseball(int position, int number) {
		this.position = position;
		this.number = number;
	}

	public BaseballState compareTo(Baseball baseball) {
		if (this.equals(baseball)) {
			return BaseballState.STRIKE;
		}
		if (number == baseball.number) {
			return BaseballState.BALL;
		}
		return BaseballState.NOTHING;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Baseball baseball = (Baseball)o;
		return position == baseball.position && number == baseball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, number);
	}
}
