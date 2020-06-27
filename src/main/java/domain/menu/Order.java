package domain.menu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
	private final Map<Menu, Amount> menuOrders;

	public Order(Map<Menu, Amount> menuOrders) {
		Objects.requireNonNull(menuOrders, "값이 존재하지 않습니다.");
		this.menuOrders = menuOrders;
	}

	public static Order empty() {
		return new Order(new HashMap<>());
	}

	public int calculatePrice() {
		return menuOrders.entrySet().stream()
			.mapToInt(entry -> entry.getKey().calculateMultiplePrice(entry.getValue()))
			.sum();
	}

	public void addMenu(Menu menu, Amount amount) {
		menuOrders.merge(menu, amount, Amount::sum);
	}

	public boolean isEmpty() {
		return menuOrders.isEmpty();
	}

	public void clear() {
		menuOrders.clear();
	}

	public Map<Menu, Amount> getMenuOrders() {
		return Collections.unmodifiableMap(menuOrders);
	}
}
