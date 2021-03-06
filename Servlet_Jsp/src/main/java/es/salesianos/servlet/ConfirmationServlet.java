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
import es.salesianos.model.Country;
import es.salesianos.model.assembler.CountryAssembler;
import es.salesianos.repository.RepositoryCountry;
import es.salesianos.service.Service;


public class ConfirmationServlet extends HttpServlet{

	private Service service = new Service();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String language = req.getParameter("countrydelete");
		    req.setAttribute("id",language);
		 req.getRequestDispatcher("Warning.jsp").forward(req, resp);
			}
	}
