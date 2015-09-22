package com.umi.oztees.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
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
import com.umi.oztees.models.Product;
import com.umi.oztees.services.CategoryService;
import com.umi.oztees.services.PageService;
import com.umi.oztees.services.ProductService;
import com.umi.oztees.utils.CustomException;

@Path("/category")
@Log
@PermitAll
public class CategoryServlet {

	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	CategoryService categoryService = new CategoryService(); 
	
	@Path("/v/{slug}")
	@GET
	public void view( @DefaultValue("") @PathParam("slug") String slug, @QueryParam("sort_by") String sort_by ) {
		
		if(slug.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'slug' is missing.");
		}
		
		ProductService ps = new ProductService();
		CategoryService categoryService = new CategoryService(); 
		
		Category category =  categoryService.loadCategory(slug); 
		if( category == null ){
			throw new CustomException(Status.NOT_FOUND, "Something went wrong.");
		}
		
		List<Category> categories =  categoryService.loadCategories(); 
		List<Product> products = ps.loadProductsByCategory(slug, sort_by);
	
		try {
			request.setAttribute("category_name", category.getName());
			request.setAttribute("category_slug", category.getSlug());
			request.setAttribute("products", products);
			request.setAttribute("sort_by", sort_by);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			log.severe(e.getMessage());
			throw new CustomException(Status.NOT_FOUND, "Something went wrong.");
		}
	}
	
	@Path("/l/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"ADMIN", "API"})
	public List<Category>  index() {
		
		List<Category> categories =  categoryService.loadCategories(); 
		return categories;
	}
	
	@Path("/e/{slug}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"ADMIN", "API"})

	public void edit( @DefaultValue("") @PathParam("slug") String slug ) {
		PageService pageService = new PageService(); 
		List<Page> pages = pageService.loadPages(); 
		Category category =  categoryService.loadCategory(slug); 
		try {
			request.setAttribute("pages", pages);
			request.setAttribute("category", category);
			request.getRequestDispatcher("/category_form.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			log.severe(e.getMessage());
			throw new CustomException(Status.NOT_FOUND, "Something went wrong.");
		}
	}
	
	@Path("/save")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
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
		
		Category newCategory =  categoryService.loadCategory(slug);
		
		if( newCategory == null ){
			newCategory = new Category();
		}
		
		newCategory.setDescription(description);
		newCategory.setName(name);
		newCategory.setSlug(slug);
		newCategory.setPriority(priority);
		categoryService.save(newCategory);
		response.sendRedirect("/category/e/"+slug);
		log.info("End save ");
	}

}
