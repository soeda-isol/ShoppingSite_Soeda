package com.isol.shopping.dto;

import lombok.Data;

@Data
public class InputRequest {

	/**商品個数*/

	private int num;

	private int itemId;

	public InputRequest() {

	}

}
