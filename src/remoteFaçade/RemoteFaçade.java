/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package remoteFaçade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import dao.IUsuarioDAO;
import dao.UsuarioDAO;
import data.Usuario;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFaçade instance;
	public Usuario state;
	private IUsuarioDAO dao; //para guardar datos, desde aquí y no usar DBManager
	
	private RemoteFaçade() throws RemoteException {
		super();
		//en el caso de que fuera así, habría que DESCOMENTAR el Construrtor de clase Usuario!!
		dao= new UsuarioDAO();
		Usuario user1= new Usuario("Inhaki", 1, "inhaki@gmail.com","1234", "4456D");
		dao.registrarUsuario(user1);
		Usuario user2= new Usuario("Annonymous", 2, "annonymous@gmail.com", "1234", "9999Z");
		dao.registrarUsuario(user2);
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
