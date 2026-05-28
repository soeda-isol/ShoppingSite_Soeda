package com.isol.shopping.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isol.shopping.entity.ItemData;
import com.isol.shopping.service.ItemService;

@Controller
public class ItemListContoroller {

	private final ItemService itemService;

	public ItemListContoroller(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping(value = "/shop/itemList")
	public String display(Model model, HttpSession session) {

		model.addAttribute("userData", session.getAttribute("loginUser"));
		/**商品情報を一覧表示処理*/

		List<ItemData> itemData = itemService.itemDownload();

		if (itemData != null) {
			model.addAttribute("itemData", itemData);
			return "shop/itemList";

		} else {
			model.addAttribute("error", "商品が存在しません");
			return "shop/itemList";
		}
	}
}
