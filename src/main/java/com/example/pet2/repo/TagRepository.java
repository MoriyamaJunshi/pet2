package com.example.pet2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet2.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {}

