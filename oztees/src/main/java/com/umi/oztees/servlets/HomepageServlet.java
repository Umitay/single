package com.umi.oztees.servlets;
import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.mvc.Viewable;

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
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CustomException(Status.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
		
		
}
