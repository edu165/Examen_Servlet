package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Country;

public class CountryAssembler {

	public static Country assembleUserFrom(HttpServletRequest req) {
		Country user = new Country();
		String pais = req.getParameter("pais");
		
		String idioma = req.getParameter("idioma");
	
		user.setPais(pais);
		user.setIdioma(idioma);
		
		return user;
	}
}