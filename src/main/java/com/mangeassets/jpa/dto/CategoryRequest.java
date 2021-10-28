package com.mangeassets.jpa.dto;

import com.mangeassets.jpa.model.Category;

public class CategoryRequest {
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryRequest [category=" + category + "]";
	}
}
