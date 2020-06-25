package domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
	@Test
	@DisplayName("같은 number를 가지는 지 확인")
	void isSameNumber() {
		Assertions.assertThat(new Menu(1, "맛치킨", Category.CHICKEN, 10_000).isSameNumber(1)).isTrue();
	}
}