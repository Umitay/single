package com.umi.oztees.servlets;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import lombok.extern.java.Log;

import com.umi.oztees.models.Page;
import com.umi.oztees.services.PageService;
import com.umi.oztees.utils.CustomException;

@Path("/page")
@Log
@PermitAll
public class PageServlet{
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	PageService pageService = new PageService(); 
	
	@Path("/v/{slug}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Page view( @DefaultValue("") @QueryParam("slug") String slug ) {
		Page page =  pageService.loadPage(slug);
		return page;
	}
	
	@Path("/l/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"ADMIN", "API"})
	public List<Page>  index() {
		List<Page> pages = pageService.loadPages(); 
		return pages;
	}
	
	@Path("/e/{slug}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"ADMIN", "API"})
	public Page edit( @DefaultValue("") @QueryParam("slug") String slug ) {
		Page page =  pageService.loadPage(slug);
		return page;
	}
	
	@Path("/save")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"ADMIN", "API"})
	public Page save (	
			@DefaultValue("") @FormParam("slug") String  slug,
			@DefaultValue("") @FormParam("name") String  name,
			@DefaultValue("") @FormParam("description") String  description,
			@DefaultValue("1000000") @FormParam("priority") Integer  priority,
			@DefaultValue("false") @FormParam("is_menu") Boolean  is_menu  ) {
		
		log.info("Start save ");
		
		if(slug.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'slug' is missing.");
		}
		
		if(name.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'name' is missing.");
		}
		
		Page newPage =  pageService.loadPage(slug);
		
		if( newPage == null ){
			newPage = new Page();
		}
		newPage.setDescription(description);
		newPage.setName(name);
		newPage.setSlug(slug);
		newPage.setPriority(priority);
		newPage.setIs_menu(is_menu);
		
		Page page = pageService.save(newPage);
		
		log.info("End save ");
		
		return page;
	}

}