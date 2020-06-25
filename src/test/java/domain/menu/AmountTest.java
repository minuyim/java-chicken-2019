package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new Amount(1)).isNotNull();
	}

	@ParameterizedTest
	@DisplayName("생성 테스트 - 범위를 벗어날 시 예외 처리")
	@ValueSource(ints = {0, 100})
	void constructorNegativeException(int amount) {
		assertThatThrownBy(() -> new Amount(amount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("메뉴 주문은");
	}

	@Test
	@DisplayName("주문 수량을 더하는 기능")
	void add() {
		assertThat(new Amount(1).add(10)).isEqualTo(new Amount(11));
	}
}
