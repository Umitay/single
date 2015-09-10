package com.umi.oztees.servlets;
import java.io.IOException;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.mvc.Viewable;

import com.umi.oztees.models.Category;
import com.umi.oztees.models.Page;
import com.umi.oztees.services.CategoryService;
import com.umi.oztees.services.PageService;
import com.umi.oztees.utils.CustomException;

import lombok.extern.java.Log;
@Path("/")
@Log
@PermitAll
public class HomepageServlet{
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	@GET
	public void  index(){
		try {
			CategoryService categoryService = new CategoryService(); 
			List<Category> categories =  categoryService.loadCategories(); 
			PageService pageService = new PageService(); 
			List<Page> pages = pageService.loadPages(); 
			
			request.setAttribute("categories", categories);
			request.setAttribute("pages", pages);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CustomException(Status.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	@Path("oz")
	@GET
	public void  oz(){
		try {
			CategoryService categoryService = new CategoryService(); 
			List<Category> categories =  categoryService.loadCategories(); 
			PageService pageService = new PageService(); 
			List<Page> pages = pageService.loadPages(); 
			
			request.setAttribute("categories", categories);
			request.setAttribute("pages", pages);
			
			request.getRequestDispatcher("/oz.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CustomException(Status.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
		
}
