package com.umi.oztees.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import lombok.extern.java.Log;

import com.umi.oztees.services.persist.EnvironmentConfig;
import com.umi.oztees.utils.CustomException;
import com.umi.oztees.utils.NetworkUtils;

@Path("/login")
@Log
@PermitAll
public class LoginServlet {
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	@GET
	public  void view() {
		
		try {
			String currentPerson = NetworkUtils.readCookieValue("p1", request );
			
			if( currentPerson != null && currentPerson.equals("offer") ){
				request.getRequestDispatcher("/oz.jsp").forward(request, response);
				log.info("the user in the session");
			}else{
				log.info("test test");
				NetworkUtils.removeCookie("p1", response );
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		} catch (ServletException | IOException e) {
			
			try {
				request.setAttribute("errors",  e.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
				throw new CustomException(Status.INTERNAL_SERVER_ERROR, e1.getMessage());
			}
		}
	}
	
	@Path("/submmit")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@RolesAllowed({"ADMIN", "API"})
	public void save (	
			@DefaultValue("") @FormParam("email") String  email,
			@DefaultValue("") @FormParam("password") String  password
		   ) {
		log.info("Start save ");
		
		String jsp="";
		List<String> errorMsg = new ArrayList<String>(); 
		
		if(email.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'email' is missing.");
		}
		
		if(password.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'password' is missing.");
		}

		if( email.equals( EnvironmentConfig.getInstance().getEmail() ) 
				&& password.equals(EnvironmentConfig.getInstance().getPassword() ) ){
			
			NetworkUtils.writeCookie(response, "p1", "offer");
			jsp = "/oz.jsp";
			
		}else{
			request.setAttribute("errors", "The passed details are empty");
			jsp = "/login.jsp";
		}
		
		try {
			request.getRequestDispatcher(jsp).forward(request, response);
		} catch (ServletException | IOException e) {
			try {
				request.setAttribute("errors",  e.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
				throw new CustomException(Status.INTERNAL_SERVER_ERROR, e1.getMessage());
			}
		}
		
		log.info("End LoginServlet::post");
	}


	
}
