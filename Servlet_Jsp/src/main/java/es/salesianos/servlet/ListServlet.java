package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Language;
import es.salesianos.model.Country;
import es.salesianos.repository.Repository;
import es.salesianos.service.Service;

public class ListServlet extends HttpServlet {
	
	private Service service = new  Service();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Country> listallcountry = service.searchallpaises();
				req.setAttribute("listAllLanguage", listallcountry);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/List.jsp");
		dispatcher.forward(req,resp);
	}
}