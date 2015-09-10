package com.umi.oztees.services;

import java.util.List;

import com.umi.oztees.models.Category;
import com.umi.oztees.services.persist.DBService;

import lombok.extern.java.Log;

@Log
public class CategoryService extends DBService{
	
	public List<Category> loadCategories() {
		return loadAll(Category.class,"priority");
	}
	
	public Category loadCategory(String slug) {
		return load(Category.class,slug);
	}
}
