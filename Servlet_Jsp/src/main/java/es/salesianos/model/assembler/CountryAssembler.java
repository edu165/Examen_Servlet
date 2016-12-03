package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Country;

public class CountryAssembler {

	public static Country assembleCountryFrom(HttpServletRequest req) {
		Country country = new Country();
		String pais = req.getParameter("pais");
		
		String idioma = req.getParameter("idioma");
	
		country.setPais(pais);
		country.setIdioma(idioma);
		
		return country;
	}
}