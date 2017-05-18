/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/

package main;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import remoteFaçade.IRemoteFaçade;
import remoteFaçade.RemoteFaçade;

public class MainTralalaServidor {
	//Main para el proyecto, lo creo basándome en el de Ebay
	
	public static void main(String[] args) {	
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		//protegido con try catch que inicializa el patrón de la Façada
		try {
			IRemoteFaçade remoteFaçade = RemoteFaçade.getInstance();
			
			Naming.rebind(name, remoteFaçade);
			System.out.println(" * Tralala server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Tralala Server Exception: " + ex.getMessage());
		}
	}
}
