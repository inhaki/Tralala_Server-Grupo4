package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Cancion;

public interface ICancionFinder extends Remote {

	public List<Cancion> getProducts() throws RemoteException;
}
