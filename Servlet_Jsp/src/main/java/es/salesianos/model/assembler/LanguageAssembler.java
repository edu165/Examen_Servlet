package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Language; 
import es.salesianos.model.Country;

public class LanguageAssembler {

	public static Language assemblecountryFrom(HttpServletRequest req) {
		Language language = new Language();
		String languages = req.getParameter("Newlanguage");
	language.setLanguage(languages);
	   return language;
	}
}