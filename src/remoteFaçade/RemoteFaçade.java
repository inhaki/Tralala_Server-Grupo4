/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package remoteFa�ade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import dao.IUsuarioDAO;
import dao.UsuarioDAO;
import data.Usuario;

public class RemoteFa�ade extends UnicastRemoteObject implements IRemoteFa�ade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFa�ade instance;
	public Usuario state;
	private IUsuarioDAO dao; //para guardar datos, desde aqu� y no usar DBManager
	
	private RemoteFa�ade() throws RemoteException {
		super();
		//en el caso de que fuera as�, habr�a que DESCOMENTAR el Construrtor de clase Usuario!!
		dao= new UsuarioDAO();
		Usuario user1= new Usuario("Inhaki", 1, "inhaki@gmail.com","1234", "4456D");
		dao.registrarUsuario(user1);
		Usuario user2= new Usuario("Annonymous", 2, "annonymous@gmail.com", "1234", "9999Z");
		dao.registrarUsuario(user2);
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
