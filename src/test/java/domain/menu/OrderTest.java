package domain.menu;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
	private MenuOrder menuOrder1;
	private MenuOrder menuOrder2;
	private MenuOrder menuOrder3;

	@BeforeEach
	void setUp() {
		menuOrder1 = new MenuOrder(new Menu(1, "가", Category.CHICKEN, 10_000), new Amount(10));
		menuOrder2 = new MenuOrder(new Menu(2, "나", Category.CHICKEN, 15_000), new Amount(5));
		menuOrder3 = new MenuOrder(new Menu(3, "다", Category.BEVERAGE, 2_000), new Amount(2));
	}

	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new Order(Arrays.asList(menuOrder1, menuOrder2)));
	}

	@Test
	@DisplayName("빈 주문 내역을 반환")
	void empty() {
		assertThat(Order.empty().isEmpty()).isTrue();
	}

	@Test
	@DisplayName("주문 내역의 총 가격을 계산")
	void calculateOrderPrice() {
		Order order = new Order(Arrays.asList(menuOrder1, menuOrder2));
		assertThat(order.calculatePrice()).isEqualTo(175_000);
	}

	@Test
	@DisplayName("새로운 주문 내역을 추가")
	void add() {
		Order order = new Order(Arrays.asList(menuOrder1, menuOrder2));
		order.add(menuOrder3);
		assertThat(order.getMenuOrders()).hasSize(3);
	}

	@Test
	@DisplayName("주문 내역이 비어있는 지 확인")
	void isEmpty() {
		assertThat(new Order(Collections.emptyList()).isEmpty()).isTrue();
	}
}
