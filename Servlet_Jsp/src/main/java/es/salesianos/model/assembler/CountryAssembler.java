package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Country;

public class CountryAssembler {

	public static Country assembleCountryFrom(HttpServletRequest req) {
		Country country = new Country();
		String country2 = req.getParameter("country");
		
		String language = req.getParameter("language");
	
		country.setCountry(country2);
		country.setLanguage(language);
		
		return country;
	}
}