package com.isol.shopping.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isol.shopping.dto.InputRequest;
import com.isol.shopping.entity.ItemData;
import com.isol.shopping.service.ItemService;
import com.isol.shopping.utillity.LogUtil;

@Controller
public class InputContoroller {

	@Autowired
	private ItemService itemService;

	//"name"などはhtmlで定義したものと一致させる
	@GetMapping(value = "/shop/input")
	public String display(@RequestParam("itemId") int itemId,
			Model model, HttpSession session) {
		ItemData item = itemService.selectItemData(itemId);
		model.addAttribute("itemId", itemId);
		model.addAttribute("itemName", item.getItemName());
		model.addAttribute("genre", item.getGenre());
		model.addAttribute("price", item.getPrice());
		model.addAttribute("stock", item.getStock());
		model.addAttribute("info", item.getInfo());
		model.addAttribute("userData", session.getAttribute("loginUser"));
		LogUtil.info("購入者情報を表示します。{}",session.getAttribute("loginUser"));

		return "shop/input";
	}

	@PostMapping("/shop/input")
	public String input(Model model,
			@ModelAttribute InputRequest inputRequest,
			@RequestParam("itemId") int itemId,
			RedirectAttributes redirectAttributes) {

		int num = inputRequest.getNum();
		int stock = itemService.selectItemData(itemId).getStock();

		if (num <= stock) {

			model.addAttribute("number", num);
			System.out.println(num);
			redirectAttributes.addFlashAttribute("request", inputRequest);
			return "redirect:/shop/confirm";
		} else {
			model.addAttribute("error", "在庫が足りません");
			return "shop/input";
		}

	}
}
