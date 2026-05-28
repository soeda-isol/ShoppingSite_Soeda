package com.isol.shopping.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignUpMapper {
	
	@Insert("INSERT INTO user_data (login_id,user_name,password,address,phone_number)VALUES(#{loginId},#{userName},#{password},#{address},#{phoneNumber})")
	void insertUserData(@Param ("loginId")String loginId,@Param("userName")String userName,@Param("password")String password,@Param("address")String address,@Param("phoneNumber")String phoneNumber);

}
