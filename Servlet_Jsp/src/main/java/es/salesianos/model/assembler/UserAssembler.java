package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public class UserAssembler {

	public static User assembleUserFrom(HttpServletRequest req) {
		User user = new User();
		String pais = req.getParameter("pais");
		
		String idioma = req.getParameter("idioma");
	
		user.setPais(pais);
		user.setIdioma(idioma);
		
		return user;
	}
}