package domain;

import domain.menu.Order;

public class TestOrderDiscountStrategy implements OrderDiscountStrategy {
	@Override
	public int calculate(Order order) {
		return (int)(order.calculatePrice() * 0.5);
	}
}
