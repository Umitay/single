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
import com.umi.oztees.utils.EncodingUtil;
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
			
			if( currentPerson != null && EncodingUtil.MD5("offer" + EnvironmentConfig.SECRET_KEY).equals(currentPerson) ){
				response.sendRedirect("/oz");
				log.info("the user in the session");
			}else{
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
	
	@Path("/submit")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void save (	
			@DefaultValue("") @FormParam("email") String  email,
			@DefaultValue("") @FormParam("password") String  password
		   ) throws IOException, ServletException {
		log.info("Start save ");
			
		if(email.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'email' is missing.");
		}
		
		if(password.length() <=0 ){
			throw new CustomException(Status.BAD_REQUEST, "Field 'password' is missing.");
		}

		if( email.equals( EnvironmentConfig.getInstance().getEmail() ) 
				&& password.equals(EnvironmentConfig.getInstance().getPassword() ) ){
			log.info("writeCookie ");
			NetworkUtils.writeCookie(response, "p1", "offer");
			log.info("the user in the session");
			response.sendRedirect("/oz");
			
		}else{
			log.info("The passed details are wrong");
			request.setAttribute("errors", "The passed details are wrong");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		log.info("End LoginServlet::post");
	}


	
}
