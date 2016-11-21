package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Idiomas;
import es.salesianos.model.User;
import es.salesianos.model.assembler.IdiomasAssembler;
import es.salesianos.model.assembler.UserAssembler;
import es.salesianos.repository.Repository;


public class Service {
	
	
	private Repository repository = new Repository();
	
	private ConnectionManager manager = new ConnectionH2();
	
	public User assembleUserFromRequest(HttpServletRequest req) {
		return UserAssembler.assembleUserFrom(req);
	}
	public Idiomas assembleIdiomasrFromRequest(HttpServletRequest req) {
		return IdiomasAssembler.assembleUserFrom(req);
	}
	public void CreateTable(){
		repository.CreateTableIdiomas();
		repository.CreateTablePaises();
		
	}
	public void InsertIdiomas(Idiomas idiomas){
		repository.InsertIdiomas(idiomas);
	}
	public List SearchAllPaises(){
		return repository.SearchAll_Paises();
	}
	


	public void InsertOrUpdate(User userFormulario) {
		Repository repository = new Repository();
		repository.CreateTableIdiomas();
		
		User userInDatabase = repository.search(userFormulario);
	
		
		if(null == userInDatabase){
			repository.InserPaises(userFormulario);
		}else{
			repository.Update(userFormulario);
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
		repository.DeletePais(user);
		repository.DeleteIdiomas(user);
	
	}
	
	
	
}

