package com.isol.shopping.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isol.shopping.entity.HistoryData;
import com.isol.shopping.entity.UserData;
import com.isol.shopping.repository.HistoryDataMapper;

@Controller
public class HistoryController {
	@Autowired
	private HistoryDataMapper historyDataMapper;

	@GetMapping(value = "/shop/history")
	public String selectHistoryDataId(Model model, HttpSession session) {

		UserData userData = (UserData) session.getAttribute("loginUser");

		List<HistoryData> historyList = historyDataMapper.selectUserDataId(((Number) userData.getUserId()).intValue());
		
		model.addAttribute("historyList", historyList);

		model.addAttribute("userData", session.getAttribute("loginUser"));

		return "/shop/history";
	}
}