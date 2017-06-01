/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package remoteFa�ade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Cancion;

public interface IRemoteFa�ade extends Remote{
	//Caso de Uso 1: Login
	//habr� que inlcuir el objeto usuario, nombre y contrase�a
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	
	//Caso de Uso 2: canciones
	//Habr� que incluir la llamada al objeto canci�n, a la que se quiera reproducir
	//public buscarCancion()
	
	//m�todo env�oPago
	public boolean envioPago(double cantidad) throws RemoteException;
	
	//m�todo registrar Usuario
	public void registrarUsuario(String mail, String Password);

	public List<Cancion> getProducts() throws RemoteException;
}