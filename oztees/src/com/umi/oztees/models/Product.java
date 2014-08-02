package com.umi.oztees.models;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Cache
@Entity(name = "Product")
public class Product {
	
	private static final Logger log = Logger.getLogger(Product.class.getName());
	@Id
	private Long CID;
	public String brand = null;
	public String name = null;
	
	@Index
	public String main_category = null;
	@Index
	public String category = null;
	@Index
	public String code = null;
	
	public String supplier_price = null;
	public String multiple_price = null;
	public String approved_price = null;
	public String colour = null;
	public String size  = null;
	public String gender = null;
	public String link = null;
	public String picture = null;
	public String description = null;
	public String more_text = null;
	public Long getCID() {
		return CID;
	}
	public void setCID(Long cID) {
		CID = cID;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMain_category() {
		return main_category;
	}
	public void setMain_category(String main_category) {
		this.main_category = main_category;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMore_text() {
		return more_text;
	}
	public void setMore_text(String more_text) {
		this.more_text = more_text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSupplier_price() {
		return supplier_price;
	}
	public void setSupplier_price(String line) {
		this.supplier_price = line;
	}
	public String getMultiple_price() {
		return multiple_price;
	}
	public void setMultiple_price(String line) {
		this.multiple_price = line;
	}
	public String getApproved_price() {
		return approved_price;
	}
	public void setApproved_price(String approved_price) {
		this.approved_price = approved_price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String line) {
		this.link = line;
	}
	
	
	
}
