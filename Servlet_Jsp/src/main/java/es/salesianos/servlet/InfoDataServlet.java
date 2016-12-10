package es.salesianos.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Language;
import es.salesianos.model.Country;
import es.salesianos.model.assembler.CountryAssembler;
import es.salesianos.service.Service;

import es.salesianos.repository.RepositoryCountry;


public class InfoDataServlet extends HttpServlet{
	
	private Service service = new Service();

	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Country country = service.assembleCountryFromRequest(req);
		Language language = service.assembleLanguagerFromRequest(req);
		service.createTable();
	    service.insertOrUpdate(country);
		service.insertLaguages(language);
        redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/List.jsp");
		dispatcher.forward(req,resp);
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
}
