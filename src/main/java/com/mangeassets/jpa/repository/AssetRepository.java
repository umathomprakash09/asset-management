package com.mangeassets.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mangeassets.jpa.model.Asset;

public interface AssetRepository extends JpaRepository<Asset,Integer> {
	
	public List<Asset> findByName(String name);

}
