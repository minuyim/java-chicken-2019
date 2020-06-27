package domain.order;

import java.util.Objects;

public class Amount {
	private static final int MAX = 99;
	private static final int MIN = 1;

	private final int amount;

	public Amount(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		if (amount < MIN) {
			throw new IllegalArgumentException("메뉴 주문은 " + MIN + "개보다 적을 수 없습니다. amount : " + amount);
		}
		if (amount > MAX) {
			throw new IllegalArgumentException("메뉴 주문은 " + MAX + "개보다 많을 수 없습니다. amount : " + amount);
		}
	}

	public static Amount sum(Amount first, Amount second) {
		return new Amount(first.amount + second.amount);
	}

	public Amount add(int other) {
		return new Amount(amount + other);
	}

	public int calculateSum(int other) {
		return other + amount;
	}

	public int multiply(int price) {
		return amount * price;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amount amount1 = (Amount)o;
		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
