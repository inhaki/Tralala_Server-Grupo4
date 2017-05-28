/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package services;

import java.util.ArrayList;
import java.util.List;

import data.Usuario;

public class LoginService {
	//la clase LoginService es de tipo
	//<<AppService>> y <<Singleton>>
	private static LoginService instance;
	
	//lista con los usuarios de Tralala
	//lista Interna que el Gateway deberá comprobar para ver si existe ese usuario
		private List<Usuario> usersCache;
	
	private LoginService() { 
		
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
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}
	
	//para el Servicio de Login
	//store
	public boolean store(Usuario user) {
			this.usersCache.add(user);
			
			return true;
	} 
	
	//método para comprobar si existe el usuario
	//en caso de que exista, habiendo pasado el email y contraseña,
	//devuelve true
	public boolean getUser(String email, String contraseña) {
			//recorre la caché interna de usuarios y devuelve true si está la cuenta
			for (Usuario user : this.usersCache) {
				if (user.getEmail().equalsIgnoreCase(email) && (user.getContraseña().equalsIgnoreCase(contraseña))) {
					return true;
				}
			}
			
			return false;
	}
}
