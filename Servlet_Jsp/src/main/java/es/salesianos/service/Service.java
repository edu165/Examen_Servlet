package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Country;
import es.salesianos.model.Language;
import es.salesianos.model.assembler.CountryAssembler;
import es.salesianos.model.assembler.LanguageAssembler;
import es.salesianos.repository.RepositoryCountry;
import es.salesianos.repository.RepositoryLanguage;

public class Service {
	private RepositoryCountry repositoryCountry = new RepositoryCountry();
	private RepositoryLanguage repositoryLanguage = new RepositoryLanguage();

	private ConnectionManager manager = new ConnectionH2();

	public Country assembleCountryFromRequest(HttpServletRequest req) {
		return CountryAssembler.assembleCountryFrom(req);
	}

	public Language assembleLanguagerFromRequest(HttpServletRequest req) {
		return LanguageAssembler.assemblecountryFrom(req);
	}

	public void createTable() {
		repositoryCountry.createTableCountry();
		;
		;
		repositoryLanguage.createTableLanguage();

	}

	public void insertLaguages(Language language) {

		repositoryLanguage.insertLaguages(language);
	}

	public List<Country> searchAllCountries() {
		return repositoryCountry.searchAllcountry();
	}

	public List<Language> SearchAllIlanguage() {
		return repositoryLanguage.searchallLanguages();

	}

	public void insertOrUpdate(Country country) {
		repositoryCountry.createTableCountry();
		;
		Country countryInDatabase = repositoryCountry.search(country);

		if (null == countryInDatabase) {
			repositoryCountry.insertCountry(country);
		} else {
			repositoryCountry.update(country);
		}
	}

	public ConnectionManager getManager() {
		return manager;
	}

	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}

	public void delete(String country) {

		repositoryCountry.deleteCountry(country);
		repositoryLanguage.deleteLanguage(country);

	}

}
