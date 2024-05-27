package com.example.pet2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet2.model.Category;
import com.example.pet2.model.Pet;
import com.example.pet2.model.Tag;
import com.example.pet2.repo.CategoryRepository;
import com.example.pet2.repo.PetRepository;
import com.example.pet2.repo.TagRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetId(Long petId) {
        return petRepository.findById(petId);
    }

    public List<Pet> findPetsByStatus(String status) {
        return petRepository.findByStatus(status);
    }

    public List<Pet> findPetsByTags(String tagName) {
        return petRepository.findByTags_Name(tagName);
    }

    @Transactional
    public void addPet(Pet pet) {
        if (pet.getCategory() != null) {
            if (pet.getCategory().getId() == null || pet.getCategory().getId() == 0) {
                Category category = categoryRepository.save(pet.getCategory());
                pet.setCategory(category);
            } else {
                Optional<Category> categoryOpt = categoryRepository.findById(pet.getCategory().getId());
                if (categoryOpt.isPresent()) {
                    pet.setCategory(categoryOpt.get());
                } else {
                    Category category = categoryRepository.save(pet.getCategory());
                    pet.setCategory(category);
                }
            }
        }

        if (pet.getTags() != null) {
            for (Tag tag : pet.getTags()) {
                if (tag.getId() == null || tag.getId() == 0) {
                    Tag savedTag = tagRepository.save(tag);
                    tag.setId(savedTag.getId());
                } else {
                    Optional<Tag> tagOpt = tagRepository.findById(tag.getId());
                    if (tagOpt.isPresent()) {
                        tag.setId(tagOpt.get().getId());
                    } else {
                        Tag savedTag = tagRepository.save(tag);
                        tag.setId(savedTag.getId());
                    }
                }
            }
        }

        petRepository.save(pet);
    }

    @Transactional
    public void updateAllPets(Pet pet) {
        if (pet.getCategory() != null) {
            if (pet.getCategory().getId() == null || pet.getCategory().getId() == 0) {
                Category category = categoryRepository.save(pet.getCategory());
                pet.setCategory(category);
            } else {
                Optional<Category> categoryOpt = categoryRepository.findById(pet.getCategory().getId());
                if (categoryOpt.isPresent()) {
                    pet.setCategory(categoryOpt.get());
                } else {
                    Category category = categoryRepository.save(pet.getCategory());
                    pet.setCategory(category);
                }
            }
        }

        if (pet.getTags() != null) {
            for (Tag tag : pet.getTags()) {
                if (tag.getId() == null || tag.getId() == 0) {
                    Tag savedTag = tagRepository.save(tag);
                    tag.setId(savedTag.getId());
                } else {
                    Optional<Tag> tagOpt = tagRepository.findById(tag.getId());
                    if (tagOpt.isPresent()) {
                        tag.setId(tagOpt.get().getId());
                    } else {
                        Tag savedTag = tagRepository.save(tag);
                        tag.setId(savedTag.getId());
                    }
                }
            }
        }

        petRepository.save(pet);
    }

    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }

    @Transactional
    public void updatePet(Long petId, Pet pet) {
        if (petRepository.existsById(petId)) {
            if (pet.getCategory() != null) {
                if (pet.getCategory().getId() == null || pet.getCategory().getId() == 0) {
                    Category category = categoryRepository.save(pet.getCategory());
                    pet.setCategory(category);
                } else {
                    Optional<Category> categoryOpt = categoryRepository.findById(pet.getCategory().getId());
                    if (categoryOpt.isPresent()) {
                        pet.setCategory(categoryOpt.get());
                    } else {
                        Category category = categoryRepository.save(pet.getCategory());
                        pet.setCategory(category);
                    }
                }
            }

            if (pet.getTags() != null) {
                for (Tag tag : pet.getTags()) {
                    if (tag.getId() == null || tag.getId() == 0) {
                        Tag savedTag = tagRepository.save(tag);
                        tag.setId(savedTag.getId());
                    } else {
                        Optional<Tag> tagOpt = tagRepository.findById(tag.getId());
                        if (tagOpt.isPresent()) {
                            tag.setId(tagOpt.get().getId());
                        } else {
                            Tag savedTag = tagRepository.save(tag);
                            tag.setId(savedTag.getId());
                        }
                    }
                }
            }

            petRepository.save(pet);
        }
    }
}


