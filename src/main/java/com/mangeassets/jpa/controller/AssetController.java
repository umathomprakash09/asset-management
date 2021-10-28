package com.mangeassets.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mangeassets.jpa.dto.AssetRequest;
import com.mangeassets.jpa.dto.CategoryRequest;
import com.mangeassets.jpa.model.Asset;
import com.mangeassets.jpa.model.Category;
import com.mangeassets.jpa.repository.AssetRepository;
import com.mangeassets.jpa.repository.CategoryRepository;

@RestController
public class AssetController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AssetRepository assetRepository;
	
	@PostMapping("/addAsset")
	public Asset addAsset(@RequestBody Asset asset) {
		Category category = categoryRepository.findById(asset.getCategory().getId()).orElse(null);
		if(null == category) {
			category = new Category();
			category.setName(asset.getCategory().getName());
			category.setDescription(asset.getCategory().getDescription());
			categoryRepository.save(category);
			System.out.println("In the if....");
		}
		
		asset.setCategory(category);
		
		return assetRepository.save(asset);
	}
	@GetMapping("/assets")
	public List<Asset> getAssets(){
		return assetRepository.findAll();
	}
	
	@GetMapping("/assets/{name}")
	public List<Asset> getAssets(@PathVariable String name){
		return assetRepository.findByName(name);
	}
	
	@PutMapping("/assets/{id}")
	public Asset updateAsset(@RequestBody Asset request,@PathVariable int id) {
		Asset asset = assetRepository.findById(id).get();
		if(null == asset) {
			return assetRepository.save(request);
		}
		asset.setId(id);
		asset.setName(request.getName());
		asset.setCategory(request.getCategory());
		return assetRepository.save(asset);
	}

}
