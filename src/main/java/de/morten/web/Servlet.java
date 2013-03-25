package de.morten.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="myServlet", urlPatterns={"/servlet"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		PrintWriter writer = res.getWriter();
		writer.write("Hello, Servlet");
	}	
}
