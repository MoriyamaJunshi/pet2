package com.example.pet2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pet2.model.Pet;

@Service
public class PetService {

	private List<Pet> allPets = new ArrayList<>(Arrays.asList(
			new Pet(null, null, "10001", null, null, null)));
	
	public List<Pet> getAllPets(){
		return allPets;
	}
	
	public Pet getPetId(String PetId) {
		for(int i=0; i<allPets.size(); i++) {
			if(allPets.get(i).getId().equals(PetId)) {
				return (Pet)allPets.get(i);
			}
		}			
		return null;
	}
	
	public void addPet (Pet pet) {
		allPets.add(pet);
	}
}
