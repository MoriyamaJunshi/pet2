package com.example.pet2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet2.model.Pet;

@RestController
@RequestMapping("/pet")
public class PetController {

	@GetMapping
	public List<Pet> getAllPets() {
		List<Pet> allPets = Arrays.asList(
				new Pet(null, null, "10001", null, null, null));
		return allPets;
	}
}
