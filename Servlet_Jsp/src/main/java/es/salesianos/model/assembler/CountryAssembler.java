package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Country;

public class CountryAssembler {

	public static Country assembleCountryFrom(HttpServletRequest req) {
		Country country = new Country();
		String countryname = req.getParameter("country");
		
		String language = req.getParameter("language");
	
		country.setCountry(countryname);
		country.setLanguage(language);
		
		return country;
	}
}