package com.umi.oztees.servlets;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umi.oztees.mappers.ProductMapper;
import com.umi.oztees.models.Product;
import com.umi.oztees.utils.Csv;

@SuppressWarnings("serial")
public class CSVServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(CSVServlet.class.getName());
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		try {
			req.getRequestDispatcher("csv_loader.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String fileName = req.getParameter("filename");
		
		Csv csvManager = new Csv();
		csvManager.setUrl(fileName);
		List <String[]>  content = csvManager.fetchContent();
		ProductMapper pm = new ProductMapper(); 
		pm.loadToDatastroge(content , fileName);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Data from the file: "+fileName+" was loaded to data store");
	}

}
