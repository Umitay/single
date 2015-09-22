package com.umi.oztees.services;

import java.util.ArrayList;
import java.util.List;

import com.umi.oztees.models.Category;
import com.umi.oztees.models.Product;
import com.umi.oztees.services.persist.DBService;

import lombok.extern.java.Log;


@Log
public class ProductService extends DBService{
	public List<Product> loadProducts() {
		return loadAll(Product.class);
	}

	public Product loadProduct(String slug) {
		return load(Product.class,slug);
	}

	public List<Product> loadProductsByCategory(String main_category_slug, String sort_by) {
		if(sort_by != null && !"code".equals(sort_by) ){
			return load(Product.class,"main_category_slug", main_category_slug,sort_by);
		}else{
			return load(Product.class,"main_category_slug", main_category_slug);
		}
	}

	public void loadToDatastroge(List<String[]> content, String filename) {
		log.info("Start uploadCsvtoDataStore");
		CategoryService categoryService = new CategoryService(); 
		
		String[] line= null;
		List<Product> productList = new ArrayList();
		String[] header = content.get(0);
		
		String main_category_slug = filename.substring(0,filename.indexOf("."));
		main_category_slug = main_category_slug.trim().toLowerCase();
		
		String main_category_name = Character.toUpperCase(main_category_slug.charAt(0)) + main_category_slug.substring(1);
		main_category_name = main_category_name.replaceAll("-", " ");
				
		for (int rowIndex= 1; rowIndex < content.size(); rowIndex++) {
			line = content.get(rowIndex);
			Product product = new Product();
			for(int colIndex = 0; colIndex < line.length; colIndex++){
				
				if(line[colIndex] != null && header[colIndex] !=null){
					
					switch (header[colIndex]) {
						case "name": product.setName(line[colIndex]); break;
						case "brand": product.setBrand(line[colIndex]); break;
						case "category": product.setCategory_name(line[colIndex]); break;
						case "code": product.setCode(line[colIndex]); break;
						case "description": product.setDescription(line[colIndex]); break;
						case "more_text": product.setMore_text(line[colIndex]); break;
						case "supplier": product.setSupplier_price(line[colIndex]); break;
						case "multiple": product.setMultiple_price(line[colIndex]); break;
						case "price": product.setApproved_price(line[colIndex]); break;
						case "tier_price": product.setTier_price(line[colIndex]); break;
						case "tier_text": product.setTier_text(line[colIndex]); break;
						case "colour": product.setColour(line[colIndex]); break;
						case "size": 
							if(line[colIndex].isEmpty()) { 
								product.setSize("OneSize");
							}else{
								product.setSize(line[colIndex]);
							}
							break;
						case "gender": 
							if(line[colIndex].isEmpty()) { 
								product.setGender("Unisex"); 
							}else{
								product.setGender(line[colIndex]); 
							}
							break;
						case "link": product.setLink( line[colIndex]); break;
						default:log.info("unregistered column "+header[colIndex]); break;
					}
					
				}// end of if
				
			}// end of loop by colindex
			
			if(!product.getName().isEmpty()){
				
				product.setPicture("https://storage.googleapis.com/www.oztees.com/"+main_category_slug+"/"+product.getCode()+".jpg");
				product.setMain_category_slug(main_category_slug);
				log.info("Product"+product.toString());
				productList.add(product);
			}
		}// end of cycle
		
		
		if(!productList.isEmpty()){
		  
		  Category category = new Category();
		  category.setImage_url(productList.get(0).getPicture());
		  category.setName(main_category_name);
		  category.setSlug(main_category_slug);
		  category = categoryService.save(category);
		  
		  if( category != null ){
			  save(productList);
		  }
		}
		 log.info("end uploadCsv toDataStore");
	}
}
