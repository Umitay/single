package com.umi.oztees.mappers;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import com.umi.oztees.models.Product;
import com.umi.oztees.services.Datastore;
import com.umi.oztees.services.ObjectDatastore;


public class ProductMapper {
	 private static final Logger log = Logger.getLogger(ProductMapper.class.getName());
	 public Product model ;
	 public ObjectDatastore datastore;
	 
public ProductMapper() {
		this(Datastore.get());
	}
public ProductMapper(ObjectDatastore datastore) {
		super();
		this.datastore = datastore;
	}
public void loadToDatastroge(List<String[]> content, String fileName) {
	log.info("Start uploadCsvtoDataStore");
	String[] line= null;
	String[] header = content.get(0);
	String page = fileName.substring(0,fileName.indexOf("."));
	for (int rowIndex= 1; rowIndex < content.size(); rowIndex++) {
		line = content.get(rowIndex);
		Product product = new Product();
		for(int colIndex = 0; colIndex < line.length; colIndex++){
			
			if(line[colIndex] != null && header[colIndex] !=null){
				
				switch (header[colIndex]) {
					case "name": product.setName(line[colIndex]); break;
					case "brand": product.setBrand(line[colIndex]); break;
					case "category": product.setCategory(line[colIndex]); break;
					case "code": product.setCode(line[colIndex]); break;
					case "description": product.setDescription(line[colIndex]); break;
					case "more_text": product.setMore_text(line[colIndex]); break;
					case "supplier": product.setSupplier_price(line[colIndex]); break;
					case "multiple": product.setMultiple_price(line[colIndex]); break;
					case "price": product.setApproved_price(line[colIndex]); break;
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
			product.setPicture(page+"/"+product.getCode()+".jpg");
			product.setMain_category(page);
			log.info("Product"+product.toString());
			datastore.store(product);
		}
	}
	 log.info("end uploadCsv toDataStore");
}
 
 
 
}
