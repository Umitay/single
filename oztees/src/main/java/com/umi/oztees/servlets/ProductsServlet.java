/*package com.umi.oztees.servlets;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import lombok.extern.java.Log;

import com.umi.oztees.mappers.ProductMapper;
import com.umi.oztees.models.Product;

@Path("/product")
@Log
@PermitAll
public class ProductsServlet{
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	@Path("/{category}")
	@GET
	public void index( @DefaultValue("") @QueryParam("signature") String signature ) {
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setCharacterEncoding("UTF-8");
		if (req.getCharacterEncoding() == null) {
		    req.setCharacterEncoding("UTF-8");
		}
		resp.setContentType("text/html; charset=UTF-8");
		ProductMapper pm = new ProductMapper(); 
		String pathInfo = req.getPathInfo();

		if (pathInfo == null){
		  req.getRequestDispatcher("404.jsp").forward(req, resp);
		}else{
			String main_category = pathInfo.substring(1);
			main_category = Character.toUpperCase(main_category.charAt(0)) + main_category.substring(1);
			List<Product>  products = pm.datastore.find(Product.class, "main_category",main_category);
			req.setAttribute("title", main_category);
			req.setAttribute("products", products);
			req.getRequestDispatcher("/products/list.jsp").forward(req, resp);
		}
	}
}
*/