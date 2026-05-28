package com.isol.shopping.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.isol.shopping.dto.LoginRequest;

@Controller
public class MenuController {

	@GetMapping(value = "/shop/menu")
	public String display(@ModelAttribute LoginRequest loginRequest, Model model,HttpSession session) {
 
//		System.out.println(loginRequest.getLoginId());
//		System.out.println(loginRequest.getPassword());

		model.addAttribute("userData", session.getAttribute("loginUser"));

		return "shop/menu";
	}

}
