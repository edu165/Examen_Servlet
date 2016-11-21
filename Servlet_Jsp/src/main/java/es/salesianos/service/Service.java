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
		repository.Create_Table_Idiomas();
		repository.CreateTablePaises();
		
	}
	public void InsertIdiomas(Idiomas idiomas){
		repository.InsertIdiomas(idiomas);
	}
	public List SearchAllPaises(){
		return repository.SearchAll_Paises();
	}
	


	public void InsertOrUpdate(Pais userFormulario) {
		Repository repository = new Repository();
		repository.Create_Table_Idiomas();
		
		Pais userInDatabase = repository.search(userFormulario);
	
		
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

