package com.isol.shopping.entity;

import lombok.Data;

@Data
public class ItemData {
	/**商品ID*/
	private int itemId;

	/**商品ジャンル*/
	private String genre;

	/**商品名*/
	private String itemName;

	/**商品価格*/
	private int price;

	/**商品在庫数*/

	private int stock;

	/**商品詳細*/

	private String info;

	public ItemData() {

	}
}
