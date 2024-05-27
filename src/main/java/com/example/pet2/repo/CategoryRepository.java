package com.example.pet2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet2.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

