/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package remoteFaçade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import services.LoginService;
import dao.ITralalaDAO;
import dao.TralalaDAO;
import data.Cancion;
import data.Usuario;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	private static final long serialVersionUID = 1L;
	//para luego hacer la instancia con el Singleton
	private static RemoteFaçade instance;
	public Usuario state;
	private ITralalaDAO dao; //para guardar datos, desde aquí y no usar DBManager
	
	private RemoteFaçade() throws RemoteException {
		super();
		//en el caso de que fuera así, habría que DESCOMENTAR el Construrtor de clase Usuario!!
		//HAY QUE REGISTRAR USUARIOS EN ALGUN LADO 
		dao= new TralalaDAO();
		Usuario user1= new Usuario("Inhaki", 1, "inhaki@gmail.com","1234", "4456D");
		dao.registrarUsuario(user1);
		Usuario user2= new Usuario("Annonymous", 2, "annonymous@gmail.com", "1234", "9999Z");
		dao.registrarUsuario(user2);
		Usuario user3= new Usuario("Hacker", 3, "hack@gmail.com", "0000", "0000A");
		dao.registrarUsuario(user3);
	}
	
	//patrón Singleton
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
	//ESTO HA DE IR AL GATEWAY!!! Y DEL GATEWAY IRÁ AL LoginService
	public boolean login(String email, String password) {		
		
		//this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}
	
	//TENDRÍAMOS QUE TENER AQUÍ EL MÉTODO
	//QUE LLAME A DTO Y RECOJA EN UNA LISTA
	//LAS CANCIONES QUE HAYA EN BBDD, MIRAR 4.2 DTO
	//public ... buscarCancion(); implementar
	
	@Override
	public boolean envioPago(double cantidad) throws RemoteException {
		// TODO Auto-generated method stub
		//aquí entraría en juego el gateway externo para pagos
		//guardaría las contraseñas de PayPal y el numCC en el DTO de Pagos
		//se apoya en el PagoAssembler...
		return false;
	}

	@Override
	public void registrarUsuario(String mail, String Password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cancion> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
