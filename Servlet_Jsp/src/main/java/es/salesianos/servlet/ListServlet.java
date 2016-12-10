package es.salesianos.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Country;
import es.salesianos.service.Service;

public class ListServlet extends HttpServlet {

	List<Country> listAllCountries = new ArrayList<Country>();
	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		listAllCountries = service.searchAllCountries();
		req.setAttribute("listAllCountries", listAllCountries);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/List.jsp");
		dispatcher.forward(req, resp);
	}
}