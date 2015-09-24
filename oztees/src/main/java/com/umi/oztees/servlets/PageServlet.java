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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import lombok.extern.java.Log;

import com.umi.oztees.models.Category;
import com.umi.oztees.models.Page;
import com.umi.oztees.services.CategoryService;
import com.umi.oztees.services.PageService;
import com.umi.oztees.utils.CustomException;
import com.umi.oztees.utils.NetworkUtils;

@Path("/page")
@Log
@PermitAll
public class PageServlet{
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	PageService pageService = new PageService(); 
	
	@Path("/v/{slug}")
	@GET
	public void view( @DefaultValue("") @PathParam("slug") String slug ) {
		CategoryService categoryService = new CategoryService(); 
		List<Category> categories =  categoryService.loadCategories(); 
		Page page =  pageService.loadPage(slug);
		try {
			request.setAttribute("categories", categories);
			request.setAttribute("page", page);
			if(slug.equals("contact")){
				request.getRequestDispatcher("/contact.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/page.jsp").forward(request, response);
			}
		} catch (ServletException | IOException e) {
			log.severe(e.getMessage());
			throw new CustomException(Status.NOT_FOUND, "Something went wrong.");
		}
		
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
	@RolesAllowed({"ADMIN", "API"})
	public void  edit( @DefaultValue("") @PathParam("slug") String slug ) {

		Page page =  pageService.loadPage(slug);
		try {
			request.setAttribute("page", page);
			request.getRequestDispatcher("/page_form.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			log.severe(e.getMessage());
			throw new CustomException(Status.NOT_FOUND, "Something went wrong.");
		}

	}
	
	@Path("/save")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@RolesAllowed({"ADMIN", "API"})
	public void save (	
			@DefaultValue("") @FormParam("slug") String  slug,
			@DefaultValue("") @FormParam("name") String  name,
			@DefaultValue("") @FormParam("description") String  description,
			@DefaultValue("1000000") @FormParam("priority") Integer  priority,
			@DefaultValue("false") @FormParam("is_menu") Boolean  is_menu  ) throws IOException {
		
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
		pageService.save(newPage);
		
		response.sendRedirect("/page/e/"+slug);
		
		log.info("End save ");
	
	}
	
	@Path("/contact")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean order( 
			@FormParam("name") String name, 
			@FormParam("phone") String phone, 
			@FormParam("email") String email, 
			@FormParam("description") String description
			)
			throws ServletException, IOException {
		
		
		String body = "Thank you for contacting us." +  "\n\r e-mail: "+email+  "\n\r Name: "+name+ "\n\r phone: "+phone+  "\n\r Description: "+description ;
		CategoryService categoryService = new CategoryService(); 
		List<Category> categories =  categoryService.loadCategories(); 
		Page page =  pageService.loadPage("contact");
		NetworkUtils.sendMail(email,body);
		
		request.setAttribute("categories", categories);
		request.setAttribute("page", page);
		request.setAttribute("msg", "Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.");
		request.getRequestDispatcher("/contact.jsp").forward(request, response);
	return true;
	}
	
}
