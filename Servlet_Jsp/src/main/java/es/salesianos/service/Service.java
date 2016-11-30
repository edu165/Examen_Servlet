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
		repository.createrableidiomas();;
		repository.createtablepaises();
		
	}
	public void InsertIdiomas(Idiomas idiomas){
		repository.insertidiomas(idiomas);
	}
	public List SearchAllPaises(){
		return repository.searchallpaises();
	}
	public List<Idiomas> SearchAllIdiomas(){
		return repository.searchallidiomas();
		
	}
	public void insertOrUpdate(Pais userFormulario) {
	repository.createrableidiomas();
		Pais userInDatabase = repository.search(userFormulario);
	
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

