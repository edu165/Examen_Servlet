package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Idiomas;
import es.salesianos.model.User;

public class IdiomasAssembler {

	public static Idiomas assembleUserFrom(HttpServletRequest req) {
		Idiomas idioma = new Idiomas();
		
		
		String idiomas = req.getParameter("nuevoidioma");
	
		
		idioma.setIdioma(idiomas);
		
		return idioma;
	}
}