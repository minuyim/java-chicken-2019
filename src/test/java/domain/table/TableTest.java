package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.order.Amount;
import domain.menu.Category;
import domain.menu.Menu;
import domain.menu.MenuRepository;

class TableTest {
	@Test
	@DisplayName("테이블이 주어진 번호에 해당하는 지 테스트")
	void isSameNumber() {
		Assertions.assertThat(new Table(1).isSameNumber(1)).isTrue();
	}

	@Test
	@DisplayName("테이블의 주문이 비어있는 지 확인")
	void isOrderEmpty() {
		Table table = new Table(1);
		table.isOrderEmpty();
	}

	@Test
	@DisplayName("주문 정보를 테이블에 입력할 수 있는 지 확인")
	void addMenu() {
		Table table = new Table(1);
		table.addMenu(MenuRepository.menus().get(0), new Amount(10));
		assertThat(table.isOrderEmpty()).isFalse();
	}

	@Test
	@DisplayName("주문 정보를 초기화하는 지 확인")
	void clearOrder() {
		Table table = new Table(1);
		table.addMenu(MenuRepository.menus().get(0), new Amount(10));
		table.clearOrder();
		assertThat(table.isOrderEmpty()).isTrue();
	}

	@Test
	@DisplayName("테이블의 주문 내역을 계산")
	void calculateDiscountPrice() {
		Table table = new Table(1);
		table.addMenu(new Menu(1, "가", Category.CHICKEN, 10_000), new Amount(10));
		assertThat(table.calculatePrice()).isEqualTo(100_000);
	}

	@Test
	@DisplayName("테이블의 주문 내역을 할인 정책에 따라 계산")
	void calculateDiscountPriceWithDiscount() {
		Table table = new Table(1);
		table.addMenu(new Menu(1, "가", Category.CHICKEN, 10_000), new Amount(10));
		assertThat(table.calculatePrice(new TestOrderDiscountStrategy())).isEqualTo(50_000);
	}
}