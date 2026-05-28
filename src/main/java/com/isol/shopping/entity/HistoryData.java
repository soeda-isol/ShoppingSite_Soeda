package com.isol.shopping.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistoryData {
	
	private int historyId;
	
	private String itemName;

	private int userId;

	private int itemId;

	private LocalDateTime purchaseDate;
	
	private int num;

	private int sum;

	public HistoryData() {

	}

}
