package com.mangeassets.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mangeassets.jpa.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
