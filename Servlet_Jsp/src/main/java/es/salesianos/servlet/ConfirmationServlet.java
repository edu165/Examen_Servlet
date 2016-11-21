package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Pais;
import es.salesianos.model.assembler.PaisAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.service.Service;


public class ConfirmationServlet extends HttpServlet{

	private Service service = new Service();
	
	
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String idioma = req.getParameter("user");
			//System.out.println(user);
			req.setAttribute("id",idioma);

			req.getRequestDispatcher("Warning.jsp").forward(req, resp);
			
		}
	

	
}
