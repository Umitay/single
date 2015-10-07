package com.umi.oztees.models;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import lombok.Getter;
import lombok.Setter;

import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Cache
@Entity(name = "Product")
public class Product {
	
	@Id
	@Getter
	@Setter
	public String code = null;
	
	@Getter
	@Setter
	@Index
	public String brand = null;
	
	@Getter
	@Setter
	@Index
	public String name = null;
	
	@Getter
	@Setter
	@Index
	public String main_category_slug = null;
	
	@Getter
	@Setter
	@Index
	public String category_name = null;
	
	@Getter
	@Setter
	@Index
	public String supplier_price = null;
	
	@Getter
	@Setter
	@Index
	public String multiple_price = null;
	
	@Getter
	@Setter
	@Index
	public Float approved_price = null;
	
	@Getter
	@Setter
	@Index
	public String tier_price = null;
	
	@Getter
	@Setter
	@Index
	public String tier_text = null;
	
	@Getter
	@Setter
	@Index
	public String colour = null;
	
	@Getter
	@Setter
	@Index
	public String size  = null;
	
	@Getter
	@Setter
	@Index
	public String gender = null;
	
	@Getter
	@Setter
	public String link = null;
	
	@Getter
	@Setter
	public String picture = null;
	@Getter
	@Setter
	public String description = null;
	@Getter
	@Setter
	public String more_text = null;

}
