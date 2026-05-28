package com.isol.shopping.service;

import java.time.LocalDateTime;
import java.util.List;

import com.isol.shopping.entity.ItemData;

public interface ItemService {

	List<ItemData> itemDownload();

	ItemData selectItemData(Number itemId);

	void insertHistoryData(int userId,int itemId, LocalDateTime purchaseDate, String itemName,int num, int sum);
}
