package top.shahow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import top.shahow.entity.Borrower;
import top.shahow.service.IBorrowerService;

@Controller
@RequestMapping("borrower")
public class BorrowerAction {
	@Autowired
	private IBorrowerService borrowerService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String login(Borrower user, HttpSession session) {
		boolean flag = false;
		Borrower borrower = borrowerService.login(user);
		if(borrower != null) {
			session.setAttribute("borrower_login", borrower);
			flag = true;
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public String register(Borrower user) {
		boolean flag = false;
		flag = borrowerService.register(user);
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	@RequestMapping(value = "islogin", method = RequestMethod.GET)
	@ResponseBody
	public String isLogin(HttpSession session) {
		Borrower borrower = (Borrower) session.getAttribute("borrower_login");
		Gson gson = new Gson();
		return gson.toJson(borrower);
		
	}
}