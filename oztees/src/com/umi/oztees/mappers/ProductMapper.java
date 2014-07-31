package com.umi.oztees.mappers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

import com.umi.oztees.models.Product;
import com.umi.oztees.services.ObjectDatastore;


public class ProductMapper {
	 private static final Logger log = Logger.getLogger(ProductMapper.class.getName());
	 public Product model ;
	 public ObjectDatastore datastore;
	 
public void loadToDatastroge(List<String[]> content, String fileName) {
	log.info("Start uploadCsvtoDataStore");
	Class<Product>  aClass = Product.class;
	Product product = new Product();
	Field field = null;
	String[] line= null;
	String[] header = content.get(0);
	
	for (int rowIndex= 1; rowIndex < content.size(); rowIndex++) {
		line = content.get(rowIndex);
	
		for(int colIndex = 0; colIndex < line.length; colIndex++){
			
			if(line[colIndex] != null){
				
				try {
					field = aClass.getField(header[colIndex]);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					field.set(product, line[colIndex]);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// end of if
		}// end of loop by colindex
		product.setPage(fileName);
		datastore.store(product);
		
	}
	 log.info("end uploadCsv toDataStore");
}
 
 
 
}
