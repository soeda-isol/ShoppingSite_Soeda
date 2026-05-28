package com.isol.shopping.controller;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.isol.shopping.dto.InputRequest;
import com.isol.shopping.entity.ItemData;
import com.isol.shopping.entity.UserData;
import com.isol.shopping.repository.ItemDataMapper;
import com.isol.shopping.service.ItemService;

@Controller
public class DoneController {

	@Autowired
	private ItemDataMapper itemDataMapper;
	@Autowired
	private ItemService itemService;

	@GetMapping(value = "/shop/done")
	public String display(@ModelAttribute("request") InputRequest inputRequest,
			Model model,
			HttpSession session) {

		ItemData item = itemDataMapper.selectItemDataId(inputRequest.getItemId());
		int sum = item.getPrice() * inputRequest.getNum();
		int itemNo = 1000 + inputRequest.getItemId();
		model.addAttribute("itemId", inputRequest.getItemId());
		model.addAttribute("num", inputRequest.getNum());
		model.addAttribute("itemName", item.getItemName());
		model.addAttribute("price", item.getPrice());
		model.addAttribute("userData", session.getAttribute("loginUser"));

		model.addAttribute("sum", sum);

		LocalDateTime purchaseDate = LocalDateTime.now();

		model.addAttribute("time", purchaseDate);

		model.addAttribute("itemNo", itemNo);

		UserData userData = (UserData) session.getAttribute("loginUser");

		itemService.insertHistoryData(userData.getUserId(),inputRequest.getItemId(), purchaseDate, item.getItemName(),inputRequest.getNum(),
				sum);

		return "/shop/done";
	}
}
