package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Pais;

public class PaisAssembler {

	public static Pais assembleUserFrom(HttpServletRequest req) {
		Pais user = new Pais();
		String pais = req.getParameter("pais");
		
		String idioma = req.getParameter("idioma");
	
		user.setPais(pais);
		user.setIdioma(idioma);
		
		return user;
	}
}