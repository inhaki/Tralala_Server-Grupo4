/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/

package main;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import remoteFa�ade.IRemoteFa�ade;
import remoteFa�ade.RemoteFa�ade;

public class MainTralalaServidor {
	//Main para el proyecto, lo creo bas�ndome en el de Ebay
	
	public static void main(String[] args) {	
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		//protegido con try catch que inicializa el patr�n de la Fa�ada
		try {
			IRemoteFa�ade remoteFa�ade = RemoteFa�ade.getInstance();
			
			Naming.rebind(name, remoteFa�ade);
			System.out.println(" * Tralala server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Tralala Server Exception: " + ex.getMessage());
		}
	}
}
