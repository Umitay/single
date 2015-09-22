package com.umi.oztees.servlets;
import java.util.Properties;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.umi.oztees.utils.NetworkUtils;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Path("/order")
@Log
@PermitAll
public class OrderServlet{
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Boolean order( 
			@FormParam("item_name") String item_name, 
			@FormParam("item_code") String item_code, 
			@FormParam("email") String email, 
			@FormParam("description") String description,
			@FormParam("printing-embroidery") String printing
			)
			throws ServletException, IOException {
		
		
		String body = description +  "\n\r e-mail: "+email+  "\n\r Item name: "+item_name+ "\n\r Item code: "+item_code;
		
		if( printing != null ){
			
			body = body.concat(" \n\r Yes, I would like a Printing, Embroidery or Engraving quote");
			
		}
		
	return NetworkUtils.sendMail(email,body);
		
	}
	
}
