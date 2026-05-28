package com.isol.shopping.entity;

import lombok.Data;

@Data
public class UserData {
	/**ユーザーID*/
	private int userId;

	/** ログインID */
	private String loginId;
	
	/** ユーザ名 */
	private String userName;
	
	/** パスワード */
	private String password;

	/**住所*/
	private String address;
	/**電話番号*/
	private String phoneNumber;

	public UserData() {
	}
}
