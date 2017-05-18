/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package db;

import java.util.ArrayList;
import java.util.List;

import data.Usuario;

public class DBManager {
	
	private static DBManager instance;
	
	//lista con los usuarios de Tralala
	private List<Usuario> usersCache;
	//haría falta otra lista de canciones aquí
	
	private DBManager(){
		
		this.usersCache = new ArrayList<>();
		//metemos "a mano" algunos usuario
		Usuario user1= new Usuario();
		user1.setNombre("Inhaki");
		user1.setIdUser(1);
		user1.setEmail("inhaki@gmail.com");
		user1.setContraseña("1234");
		user1.setDni("4444D");
		
		Usuario user2 = new Usuario();
		user2.setNombre("Annonymous");
		user2.setIdUser(2);
		user2.setEmail("annonymous@gmail.com");
		user2.setContraseña("1234");
		user2.setDni("9999A");
		
		this.usersCache.add(user1);
		this.usersCache.add(user2);
	}
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}		
		
		return instance;
	}
	
	//para el Servicio de Login
	//store
	public boolean store(Usuario user) {
		this.usersCache.add(user);
		
		return true;
	}
	//
	public Usuario getUser(String email) {
		
		for (Usuario user : this.usersCache) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		
		return null;
	}
}
