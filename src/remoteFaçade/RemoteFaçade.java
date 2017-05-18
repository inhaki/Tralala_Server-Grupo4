/**********************************************************************
Copyright (c) 2017 Annonymous: ┐OB, AG, IG & PV? 
 **********************************************************************/
package remoteFašade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import data.Usuario;
//import services.LoginService;


public class RemoteFašade extends UnicastRemoteObject implements IRemoteFašade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFašade instance;
	public Usuario state;
	
	private RemoteFašade() throws RemoteException {
		super();		
	}
	
	public static RemoteFašade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFašade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFašade: " + ex);
			}
		}
		
		return instance;
	}
	//CASO DE USO 1, ADAPTARLO A NUESTRO PROYECTO
	//mÚtodo de Login del Fašade
	public boolean login(String email, String password) {		
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}
}
