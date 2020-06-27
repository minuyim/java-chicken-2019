package domain;

import domain.menu.Amount;
import domain.menu.Menu;
import domain.menu.Order;

public class Table {
    private final int number;
    private final Order order = Order.empty();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSameNumber(int other) {
        return number == other;
    }

    public boolean isOrderEmpty() {
        return order.isEmpty();
    }

    public void addMenu(Menu menu, Amount amount) {
        order.addMenu(menu, amount);
    }

    public void clearOrder() {
        order.clear();
    }

    public int calculatePrice() {
        return order.calculatePrice();
    }

    public int calculatePrice(OrderDiscountStrategy orderDiscountStrategy) {
        return orderDiscountStrategy.calculate(order);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
