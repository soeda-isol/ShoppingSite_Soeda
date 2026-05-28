package com.isol.shopping.dto;

import lombok.Data;

@Data
public class SignUpRequest {

	private int userId;

	private String loginId;

	private String userName;

	private String password;

	private String address;

	private String phoneNumber;

	public SignUpRequest() {

	}
}
