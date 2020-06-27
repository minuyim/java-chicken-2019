package domain;

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

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
