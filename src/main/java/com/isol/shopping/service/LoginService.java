package com.isol.shopping.service;

import com.isol.shopping.entity.UserData;

public interface LoginService {
	/**ログインを実施を許可するか*/
	UserData loginJudge(String userId, String passward);

	void insertSignUpData(String loginId, String userName, String password, String address,
			String phoneNumber);
}
