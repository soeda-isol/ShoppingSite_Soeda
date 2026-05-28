package com.isol.shopping.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isol.shopping.dto.InputRequest;
import com.isol.shopping.entity.ItemData;
import com.isol.shopping.repository.ItemDataMapper;

@Controller
public class ConfirmController {

	@Autowired
	private ItemDataMapper itemDataMapper;

	@GetMapping(value = "/shop/confirm")
	public String display(@ModelAttribute("request") InputRequest inputRequest, Model model,
			HttpSession session) {

		ItemData item = itemDataMapper.selectItemDataId(inputRequest.getItemId());
		int sum = item.getPrice() * inputRequest.getNum();
		model.addAttribute("itemId", inputRequest.getItemId());
		model.addAttribute("num",inputRequest.getNum());
		model.addAttribute("itemName", item.getItemName());
		model.addAttribute("genre", item.getGenre());
		model.addAttribute("price", item.getPrice());
		model.addAttribute("userData", session.getAttribute("loginUser"));

		model.addAttribute("sum", sum);
		return "/shop/confirm";
	}

	@PostMapping("/shop/confirm")
	public String input(@ModelAttribute InputRequest inputRequest,
			RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("request", inputRequest);
		return "redirect:/shop/done";

	}

}
