/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package remoteFaçade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import data.Usuario;
//import services.LoginService;


public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFaçade instance;
	public Usuario state;
	
	private RemoteFaçade() throws RemoteException {
		super();		
	}
	
	public static RemoteFaçade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFaçade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFaçade: " + ex);
			}
		}
		
		return instance;
	}
	//CASO DE USO 1, ADAPTARLO A NUESTRO PROYECTO
	//método de Login del Façade
	public boolean login(String email, String password) {		
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}
}
