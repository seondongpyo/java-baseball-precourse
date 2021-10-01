package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballTest {

	@Test
	void nothing() {
		Baseball baseball = new Baseball(1, 1);
		BaseballState state = baseball.compareTo(new Baseball(1, 2));
		assertThat(state).isEqualTo(BaseballState.NOTHING);
	}

}
