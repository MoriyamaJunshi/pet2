package com.example.pet2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet2.model.Pet;
import com.example.pet2.repo.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	/*
	private List<Pet> allPets = new ArrayList<>(Arrays.asList(
			new Pet(null, null, "10001", null, null, null)));
	*/
	
	public List<Pet> getAllPets(){
		List<Pet> allPets = new ArrayList<>();
		petRepository.findAll().forEach(allPets :: add);
		
		return allPets;
	}
	
	public Optional getPetId(Long petId) {		
		return petRepository.findById(petId);
	}
	
	public void addPet (Pet pet) {
		petRepository.save(pet);
	}
	
	public void updateAllPets(Pet pet) {
			petRepository.save(pet);
	}
	
	public void deletePet(Long petId) {
		  petRepository.deleteById(petId);
	}
	
	public void updatePet(Long petId, Pet pet) {
		if(petRepository.findById(petId).get() != null) {
			petRepository.save(pet);
		}			
	}
}
