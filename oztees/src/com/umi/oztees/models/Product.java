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
@Entity(name = "Products")
public class Product {
	
	private static final Logger log = Logger.getLogger(Product.class.getName());
	@Id
	private Long CID;
	
	@Index
	protected String name = null;
	@Index
	protected String category = null;
	@Index
	protected String page = null;
	@Index
	protected String code = null;
	@Ignore
	protected String description = null;
	protected Float supplier_price = null;
	protected Float multiple_price = null;
	protected Float approved_price = null;
	protected String colour = null;
	protected String size  = null;
	protected String gender = null;
	protected URL link = null;
	protected String picture = null;
	
	public Long getCID() {
		return CID;
	}
	public void setCID(Long cID) {
		CID = cID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Float getSupplier_price() {
		return supplier_price;
	}
	public void setSupplier_price(Float supplier_price) {
		this.supplier_price = supplier_price;
	}
	public Float getMultiple_price() {
		return multiple_price;
	}
	public void setMultiple_price(Float multiple_price) {
		this.multiple_price = multiple_price;
	}
	public Float getApproved_price() {
		return approved_price;
	}
	public void setApproved_price(Float approved_price) {
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
	public URL getLink() {
		return link;
	}
	public void setLink(URL link) {
		this.link = link;
	}
	
	
	
}
