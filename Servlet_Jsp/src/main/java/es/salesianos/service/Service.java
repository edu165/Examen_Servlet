package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Language;
import es.salesianos.model.Country;
import es.salesianos.model.assembler.LanguageAssembler;
import es.salesianos.model.assembler.CountryAssembler;
import es.salesianos.repository.RepositoryCountry;
import es.salesianos.repository.RepositoryLanguage
;
public class Service {
	private RepositoryCountry repositorycountry = new RepositoryCountry();
	private RepositoryLanguage repositorylanguage = new RepositoryLanguage();
	
	private ConnectionManager manager = new ConnectionH2();
	
	public Country assembleCountryFromRequest(HttpServletRequest req) {
		return CountryAssembler.assembleCountryFrom(req);
	}
	public Language assembleLanguagerFromRequest(HttpServletRequest req) {
		return LanguageAssembler.assemblecountryFrom(req);
	}
	public void createTable(){
		repositorycountry.createtablecountry();;;
		repositorylanguage.createrablelanguage();
		
	}
	public void insertLaguages(Language language){
		
		repositorylanguage.insertLaguages(language);
	}
	public List searchAllCountries(){
		return repositorycountry.searchallcountry();
	}
	public List<Language> SearchAllIlanguage(){
		return repositorylanguage.searchalllanguages();
		
	}
	public void insertorupdate(Country country) {
	repositorycountry.createtablecountry();;
		Country countryInDatabase = repositorycountry.search(country);
	
		if(null == countryInDatabase){
			repositorycountry.insertpaises(country);
		}else{
			repositorycountry.update(country);
		}
	}
	public ConnectionManager getManager() {
		return manager;
	}
	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}
	public void delete(String country){
	
		repositorycountry.deletecountry(country);
		repositorylanguage.deletelanguage(country);
	
	}
	
	}

