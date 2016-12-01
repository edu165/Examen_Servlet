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
import es.salesianos.repository.Repository;
import es.salesianos.service.Service;


public class ComebackServlet extends HttpServlet{

	private Service service = new Service();
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idioma = req.getParameter("idiomaborrar");
		req.setAttribute("idiomaborrar", idioma);
		service.Delete(idioma);
		redirect(req,resp);
	}
	

	private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/List.jsp");
		dispatcher.forward(req,resp);
	}
	
}
