/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package utils;

import data.Usuario;
import dto.UserDTO;

public class UsuarioAssembler {
	
	private static UsuarioAssembler instance;
	
	//utiliza el patrón Singleton
	//la forma de crear la instancia es Lazy
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UserDTO entityToDTO(Usuario user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setContraseña(user.getContraseña());
		dto.setDni(user.getDni());
		
		return dto;
	}
}
