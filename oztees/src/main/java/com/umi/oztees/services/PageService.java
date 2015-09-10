package com.umi.oztees.services;

import java.util.List;

import com.umi.oztees.models.Page;
import com.umi.oztees.services.persist.DBService;
import lombok.extern.java.Log;


@Log
public class PageService extends DBService{
	
	public List<Page> loadPages() {
		return loadAll(Page.class);
	}

	public Page loadPage(String slug) {
		return load(Page.class,slug);
	}

	

}
