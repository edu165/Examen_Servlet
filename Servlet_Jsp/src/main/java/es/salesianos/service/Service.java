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
		return CountryAssembler.assembleUserFrom(req);
	}
	public Language assembleLanguagerFromRequest(HttpServletRequest req) {
		return LanguageAssembler.assembleUserFrom(req);
	}
	public void CreateTable(){
		repository.createrableidiomas();;
		repository.createtablepaises();
		
	}
	public void InsertIdiomas(Language idiomas){
		repository.insertidiomas(idiomas);
	}
	public List SearchAllPaises(){
		return repository.searchallpaises();
	}
	public List<Language> SearchAllIdiomas(){
		return repository.searchallidiomas();
		
	}
	public void insertOrUpdate(Country userFormulario) {
	repository.createrableidiomas();
		Country userInDatabase = repository.search(userFormulario);
	
		if(null == userInDatabase){
			repository.insertpaises(userFormulario);
		}else{
			repository.update(userFormulario);
		}
	}
	public ConnectionManager getManager() {
		return manager;
	}
	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}
	public void Delete(String user){
	
		repository.deletepais(user);
		repository.deleteidiomas(user);
	
	}
	
	}

