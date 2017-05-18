/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package services;

import data.Usuario;
import db.DBManager;

public class LoginService {
	//la clase LoginService es de tipo
	//<<AppService>> y <<Singleton>>
	private static LoginService instance;
	
	
	private LoginService() { }
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}
	
	public Usuario login(String email, String contraseña) {
		Usuario user = DBManager.getInstance().getUser(email);
		
		if (user != null && user.checkContraseña(contraseña)) {
			return user;
		} else {
			return null;
		}
	}
}
