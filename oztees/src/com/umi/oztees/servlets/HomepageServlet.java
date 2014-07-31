package com.umi.oztees.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;
@SuppressWarnings("serial")
public class HomepageServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(HomepageServlet.class.getName());
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello home, world");
	}
}
