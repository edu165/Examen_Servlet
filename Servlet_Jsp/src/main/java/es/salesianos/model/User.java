package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String pais;
	private String idioma;
	
	
	

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	
	

	

	
	@Override
	public String toString() {
		return "User [pais=" + pais + ", idioma=" + idioma +  "]";
	}
	
	

}
