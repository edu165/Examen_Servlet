package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Language; 
import es.salesianos.model.Country;

public class LanguageAssembler {

	public static Language assemblecountryFrom(HttpServletRequest req) {
		Language idioma = new Language();
		String idiomas = req.getParameter("idioma2");
	idioma.setIdioma(idiomas);
	   return idioma;
	}
}