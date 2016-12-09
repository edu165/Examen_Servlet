package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Language;

public class LanguageAssembler {

	public static Language assemblecountryFrom(HttpServletRequest req) {
		Language language = new Language();
		String languages = req.getParameter("newlanguage");
		language.setLanguage(languages);
		return language;
	}
}