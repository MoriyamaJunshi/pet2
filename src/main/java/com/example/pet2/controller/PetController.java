package com.example.pet2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

	@GetMapping("/pet")
	public String index() {
		return "アクセス成功です";
	}
}
