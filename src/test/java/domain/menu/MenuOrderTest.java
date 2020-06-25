package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuOrderTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new MenuOrder(MenuRepository.menus().get(0), new Amount(10))).isNotNull();
	}

	@Test
	void isChickenMenu() {
		assertThat(new MenuOrder(new Menu(1, "치킨", Category.CHICKEN, 10_000),
			new Amount(10)).isChickenMenu()).isTrue();
	}

	@Test
	void calculateMenuOrderPrice() {
		assertThat(new MenuOrder(new Menu(1, "치킨", Category.CHICKEN, 10_000),
			new Amount(10)).calculateMenuOrderPrice()).isEqualTo(100_000);
	}
}
