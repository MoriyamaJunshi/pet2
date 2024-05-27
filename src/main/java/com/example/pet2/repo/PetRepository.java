package com.example.pet2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet2.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByStatus(String status);
    List<Pet> findByTags_Name(String tagName);
}
