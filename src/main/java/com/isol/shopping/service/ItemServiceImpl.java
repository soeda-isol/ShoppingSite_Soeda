package com.isol.shopping.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.isol.shopping.entity.ItemData;
import com.isol.shopping.repository.HistoryDataMapper;
import com.isol.shopping.repository.ItemDataMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ItemDataMapper itemDataMapper;
	@Autowired
	private HistoryDataMapper historyDataMapper;

	public List<ItemData> itemDownload() {

		String sql = "SELECT * FROM item_data";
		try {

			List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
			if (results.isEmpty()) {
				return null;
			}

			List<ItemData> itemList = new ArrayList<>();
			for (int i = 0; i < results.size(); i++) {

				Map<String, Object> row = results.get(i);

				ItemData item = new ItemData();

				item.setItemId(((Number) row.get("item_id")).intValue());
				item.setGenre((String) row.get("genre"));
				item.setItemName((String) row.get("item_name"));
				item.setPrice(((Number) row.get("price")).intValue());
				item.setStock(((Number) row.get("stock")).intValue());
				item.setInfo((String) row.get("info"));

				itemList.add(item);
			}
			return itemList;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	public ItemData selectItemData(Number itemId) {

		return itemDataMapper.selectItemDataId(itemId);
	}

	public void insertHistoryData(int userId,int itemId, LocalDateTime purchaseDate, String itemName,int num, int sum) {

		historyDataMapper.insertHistoryDataId(userId,itemId, purchaseDate,itemName,num,sum);
	}
}
