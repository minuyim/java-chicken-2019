package domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {
	private final List<MenuOrder> menuOrders;

	public Order(List<MenuOrder> menuOrders) {
		Objects.requireNonNull(menuOrders, "값이 존재하지 않습니다.");
		this.menuOrders = menuOrders;
	}

	public static Order empty() {
		return new Order(new ArrayList<>());
	}

	public int calculatePrice() {
		return menuOrders.stream()
			.mapToInt(MenuOrder::calculateMenuOrderPrice)
			.sum();
	}

	public void add(MenuOrder menuOrder) {
		menuOrders.add(menuOrder);
	}

	public boolean isEmpty() {
		return menuOrders.isEmpty();
	}

	public List<MenuOrder> getMenuOrders() {
		return Collections.unmodifiableList(menuOrders);
	}
}
