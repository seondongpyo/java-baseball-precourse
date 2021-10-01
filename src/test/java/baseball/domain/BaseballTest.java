package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballTest {

	private final Baseball baseball = new Baseball(1, 1);

	@Test
	void ball() {
		BaseballState state = baseball.compareTo(new Baseball(2, 1));
		assertThat(state).isEqualTo(BaseballState.BALL);
	}

	@Test
	void nothing() {
		BaseballState state = baseball.compareTo(new Baseball(1, 2));
		assertThat(state).isEqualTo(BaseballState.NOTHING);
	}

}
