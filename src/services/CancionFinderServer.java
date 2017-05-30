package services;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CancionDAO;
import dao.ICancionDAO;
import data.Cancion;


public class CancionFinderServer extends UnicastRemoteObject implements ICancionFinder {
	private ICancionDAO dao;

	private static final long serialVersionUID = 1L;
	public CancionFinderServer()throws RemoteException {
		super();
		dao = new CancionDAO();
		Cancion cancion1 = new Cancion("titulo", 3.5, "03/11/2010", 9, "letra", "rock" );
		//MIRAR CONSTRUCTOR DE CANCION
		dao.storeProduct(cancion1);

	}
	
	@Override
	public List<Cancion> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
		List<Cancion> canciones = dao.getCanciones();
		System.out.println("Returning Products to client ....");
		return canciones;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Attention: arguments missing");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			ICancionFinder server = new CancionFinderServer();
			Naming.rebind(name, server);
			System.out.println("Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("Cancion Finder Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
