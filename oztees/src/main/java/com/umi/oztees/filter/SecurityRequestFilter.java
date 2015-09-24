package com.umi.oztees.filter;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Priority;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import lombok.extern.java.Log;


@Provider
@Priority(Priorities.AUTHENTICATION)
@Log
public class SecurityRequestFilter implements ContainerRequestFilter {
		private RolesAllowed roles_allowed;
		
		public SecurityRequestFilter(RolesAllowed ra) {
			this.roles_allowed = ra;
		}

		@Override
		public void filter(ContainerRequestContext requestContext ) throws IOException {
			log.info("Start SecurityRequestFilter.filter");
			
			Boolean is_allowed = false;
			String currentPerson = null;
			List<String> raList = Arrays.asList(roles_allowed.value());
		
			if( raList.contains("ADMIN") ){
				Cookie cooke = requestContext.getCookies().get("p1");
				
				if( cooke != null ){
				 currentPerson = cooke.getValue();
				 if( currentPerson != null && currentPerson.equals("offer") ){
						is_allowed = true;
					}
				}
				
			}
			
			if (!is_allowed) {
			
		        requestContext.abortWith(
			              Response.status(Status.UNAUTHORIZED)
			              .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"403\"")
			              .entity("You don't have permission to access / on this server..  <a href='/login'> try again</a>" ).build());
				
			}
			log.info("End SecurityRequestFilter.filter");
		}
		
	}
