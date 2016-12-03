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
import es.salesianos.repository.Repository;
public class Service {
	private Repository repository = new Repository();
	private ConnectionManager manager = new ConnectionH2();
	
	public Country assembleCountryFromRequest(HttpServletRequest req) {
		return CountryAssembler.assembleCountryFrom(req);
	}
	public Language assembleLanguagerFromRequest(HttpServletRequest req) {
		return LanguageAssembler.assemblecountryFrom(req);
	}
	public void createtable(){
		repository.createrableidiomas();;
		repository.createtablepaises();
		
	}
	public void insertlaguages(Language language){
		
		repository.insertidiomas(language);
	}
	public List searchallpaises(){
		return repository.searchallcountry();
	}
	public List<Language> SearchAllIlanguage(){
		return repository.searchalllanguages();
		
	}
	public void insertorupdate(Country country) {
	repository.createrableidiomas();
		Country countryInDatabase = repository.search(country);
	
		if(null == countryInDatabase){
			repository.insertpaises(country);
		}else{
			repository.update(country);
		}
	}
	public ConnectionManager getManager() {
		return manager;
	}
	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}
	public void delete(String country){
	
		repository.deletepais(country);
		repository.deletecountry(country);
	
	}
	
	}

