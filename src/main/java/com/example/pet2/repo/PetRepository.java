package com.example.pet2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pet2.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
//CrudRepository で使用できるメソッド
//	save
//	findById(id)
//	findAll
//	deleteById(id)
}
