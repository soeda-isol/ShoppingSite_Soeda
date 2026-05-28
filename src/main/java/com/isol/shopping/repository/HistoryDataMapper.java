package com.isol.shopping.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.isol.shopping.entity.HistoryData;

@Mapper
public interface HistoryDataMapper {

	@Insert("INSERT INTO history_data (user_id,item_id,purchase_date ,item_name,num,sum) VALUES (#{userId},#{itemId},#{purchaseDate},#{itemName},#{num},#{sum})")
	void insertHistoryDataId(@Param("userId")int userId,@Param("itemId") int itemId,
			@Param("purchaseDate") LocalDateTime purchaseDate,@Param("itemName")String itemName,@Param ("num") int num,@Param ("sum")int sum);

	@Select("SELECT * FROM history_data WHERE user_id = #{userId}")
	//seqItemIdが一致するitem_dataカラムの情報を全部持ってくる
	List<HistoryData> selectUserDataId(int userId);
}