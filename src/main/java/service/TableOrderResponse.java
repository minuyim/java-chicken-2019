package service;

import java.util.List;

import service.dto.MenuOrderResponse;

public class TableOrderResponse {
	private int tableNumber;
	private List<MenuOrderResponse> menuOrderResponses;

	public TableOrderResponse(int tableNumber, List<MenuOrderResponse> menuOrderResponses) {
		this.tableNumber = tableNumber;
		this.menuOrderResponses = menuOrderResponses;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public List<MenuOrderResponse> getMenuOrderResponses() {
		return menuOrderResponses;
	}
}
