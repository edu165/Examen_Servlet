package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Idiomas;
import es.salesianos.model.Pais;
import es.salesianos.model.assembler.IdiomasAssembler;
import es.salesianos.model.assembler.PaisAssembler;
import es.salesianos.repository.Repository;


public class Service {
	
	
	private Repository repository = new Repository();
	
	private ConnectionManager manager = new ConnectionH2();
	
	public Pais assembleUserFromRequest(HttpServletRequest req) {
		return PaisAssembler.assembleUserFrom(req);
	}
	public Idiomas assembleIdiomasrFromRequest(HttpServletRequest req) {
		return IdiomasAssembler.assembleUserFrom(req);
	}
	public void CreateTable(){
		repository.createTableIdiomas();;
		repository.createTablePaises();
		
	}
	public void InsertIdiomas(Idiomas idiomas){
		repository.insertIdiomas(idiomas);
	}
	public List SearchAllPaises(){
		return repository.searchAllPaises();
	}
	


	public void insertOrUpdate(Pais userFormulario) {
		Repository repository = new Repository();
		repository.createTableIdiomas();
		
		Pais userInDatabase = repository.search(userFormulario);
	
		
		if(null == userInDatabase){
			repository.insertPaises(userFormulario);
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
		Repository repository = new Repository();
		repository.deletePais(user);
		repository.deleteIdiomas(user);
	
	}
	
	
	
}

