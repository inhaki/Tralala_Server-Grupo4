/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package remoteFa�ade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import data.Usuario;
//import services.LoginService;


public class RemoteFa�ade extends UnicastRemoteObject implements IRemoteFa�ade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFa�ade instance;
	public Usuario state;
	
	private RemoteFa�ade() throws RemoteException {
		super();		
	}
	
	public static RemoteFa�ade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFa�ade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFa�ade: " + ex);
			}
		}
		
		return instance;
	}
	//CASO DE USO 1, ADAPTARLO A NUESTRO PROYECTO
	//m�todo de Login del Fa�ade
	public boolean login(String email, String password) {		
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}
}
