package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Country;

public class CountryAssembler {

	public static Country assembleCountryFrom(HttpServletRequest req) {
		Country country = new Country();
		String country2 = req.getParameter("pais");
		
		String language = req.getParameter("idioma");
	
		country.setPais(country2);
		country.setIdioma(language);
		
		return country;
	}
}