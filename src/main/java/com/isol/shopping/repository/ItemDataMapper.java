package com.isol.shopping.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.isol.shopping.entity.ItemData;

@Mapper
public interface ItemDataMapper { 
	
	@Select("SELECT * FROM item_data WHERE item_id = #{itemId}")
	//seqItemIdが一致するitem_dataカラムの情報を全部持ってくる
	ItemData selectItemDataId(Number itemId);

}
