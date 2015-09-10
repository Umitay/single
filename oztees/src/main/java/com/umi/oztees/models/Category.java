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
@Entity(name = "Category")
public class Category {
	
	@Id
	@Getter
	@Setter
	public String  slug;
	
	@Index
	@Getter
	@Setter
	public String name;
	
	@Index
	@Getter
	@Setter
	public String  image_url;
	@Index
	@Getter
	@Setter
	public String  included_page;
	@Index
	@Getter
	@Setter
	public String description;
	@Index
	@Getter
	@Setter
	public Integer priority;
	
	
}
