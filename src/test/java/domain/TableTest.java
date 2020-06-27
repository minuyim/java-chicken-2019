package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {
	@Test
	void isSameNumber() {
		assertThat(new Table(1).isSameNumber(1)).isTrue();
	}
}