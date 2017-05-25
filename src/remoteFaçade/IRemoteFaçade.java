/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package remoteFaçade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteFaçade extends Remote{
	//Caso de Uso 1: Login
	//habrá que inlcuir el objeto usuario, nombre y contraseña
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	//Caso de Uso 2: canciones
	//Habrá que incluir la llamada al objeto canción, a la que se quiera reproducir
	
}