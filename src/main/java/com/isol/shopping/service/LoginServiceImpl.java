package com.isol.shopping.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.isol.shopping.entity.UserData;
import com.isol.shopping.repository.SignUpMapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SignUpMapper signUpMapper;

	/**
	 * ログイン処理の詳細
	 * @param loginId ログインID
	 * @param passward パスワード
	 * @return ユーザー情報
	 * */
	@Override
	public UserData loginJudge(String loginId, String passward) {
		//1.SQL文の作成r_
		//ログインIdとパスワードの両方が一致するコードを検索
		String sql = "SELECT * FROM user_data WHERE login_id = ? AND password = ?";

		try {

			List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, loginId, passward);
			if (results.isEmpty()) {
				return null;
			}

			Map<String, Object> row = results.get(0);

			UserData user = new UserData();

			user.setUserId(((Number) row.get("user_id")).intValue());
			user.setLoginId((String) row.get("login_id"));
			user.setUserName((String) row.get("user_name"));
			user.setPassword((String) row.get("passward"));
			user.setAddress((String) row.get("address"));
			user.setPhoneNumber((String) row.get("phone_number"));

			return user;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	public void insertSignUpData(String loginId, String userName, String password, String address,
			String phoneNumber) {
		signUpMapper.insertUserData(loginId, userName, password, address, phoneNumber);

	}
}
