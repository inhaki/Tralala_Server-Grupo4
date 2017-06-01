/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package remoteFaçade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Cancion;

public interface IRemoteFaçade extends Remote{
	//Caso de Uso 1: Login
	//habrá que inlcuir el objeto usuario, nombre y contraseña
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	
	//Caso de Uso 2: canciones
	//Habrá que incluir la llamada al objeto canción, a la que se quiera reproducir
	//public buscarCancion()
	
	//método envíoPago
	public boolean envioPago(double cantidad) throws RemoteException;
	
	//método registrar Usuario
	public void registrarUsuario(String mail, String Password);

	public List<Cancion> getProducts() throws RemoteException;
}