package es.salesianos.model;

public class Pais {

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
		return "User [pais=" + pais + ", idioma=" + idioma + "]";
	}

}
