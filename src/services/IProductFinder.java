package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Cancion;

public interface IProductFinder extends Remote {

	public List<Cancion> getProducts() throws RemoteException;
}
