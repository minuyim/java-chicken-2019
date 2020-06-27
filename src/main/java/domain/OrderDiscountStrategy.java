package domain;

import domain.menu.Order;

public interface OrderDiscountStrategy {
	int calculate(Order order);
}
