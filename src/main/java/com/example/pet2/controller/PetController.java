package com.example.pet2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet2.model.Pet;
import com.example.pet2.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{petId}")
    public Optional<Pet> getPet(@PathVariable("petId") Long petId) {
        return petService.getPetId(petId);
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        petService.addPet(pet);
    }

    @PutMapping
    public void updateAllPet(@RequestBody Pet pet) {
        petService.updateAllPets(pet);
    }

    @DeleteMapping("/{petId}")
    public void deletePet(@PathVariable("petId") Long petId) {
        petService.deletePet(petId);
    }

    @PostMapping("/{petId}")
    public void updatePet(@RequestBody Pet pet, @PathVariable("petId") Long petId) {
        petService.updatePet(petId, pet);
    }

    @GetMapping("/findByStatus")
    public List<Pet> findByStatus(@RequestParam String status) {
        return petService.findPetsByStatus(status);
    }

    @GetMapping("/findByTags")
    public List<Pet> findByTags(@RequestParam String tagName) {
        return petService.findPetsByTags(tagName);
    }
}

