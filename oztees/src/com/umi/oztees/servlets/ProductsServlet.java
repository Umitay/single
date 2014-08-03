package com.umi.oztees.servlets;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.umi.oztees.mappers.ProductMapper;
import com.umi.oztees.models.Product;

@SuppressWarnings("serial")
public class ProductsServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ProductsServlet.class.getName());
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
