package es.salesianos.model;

public class Country {

	private String country;
	private String language;

	public String getCountry() {
		return country;
	}

	public void setCountry(String pais) {
		this.country = pais;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String idioma) {
		this.language = idioma;
	}

	@Override
	public String toString() {
		return "User [pais=" + country + ", idioma=" + language + "]";
	}

}
