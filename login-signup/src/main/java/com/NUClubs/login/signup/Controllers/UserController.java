package com.NUClubs.login.signup.Controllers;

import com.NUClubs.login.signup.Models.User;
import com.NUClubs.login.signup.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSubmit(@RequestParam String username,
							   @RequestParam String email,
							   @RequestParam String password,
							   Model model) {
		boolean ok = userService.register(username, email, password);
		if (!ok) {
			model.addAttribute("error", "Username or email already exists");
			return "signup";
		}
		model.addAttribute("message", "Registration successful. Please log in.");
		return "login";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@RequestParam String username,
							  @RequestParam String password,
							  Model model,
							  HttpSession session) {
		User user = userService.authenticate(username, password);
		if (user == null) {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
		session.setAttribute("user", user.getUsername());
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Object username = session.getAttribute("user");
		if (username == null) {
			return "redirect:/login";
		}
		model.addAttribute("username", username.toString());
		return "home";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
