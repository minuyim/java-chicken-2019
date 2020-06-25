package domain.menu;

public class MenuOrder {
	private final Menu menu;
	private final Amount amount;

	public MenuOrder(Menu menu, Amount amount) {
		this.menu = menu;
		this.amount = amount;
	}

	public boolean isChickenMenu() {
		return menu.isChicken();
	}

	public int calculateMenuOrderPrice() {
		return menu.calculateMultiplePrice(amount);
	}
}
