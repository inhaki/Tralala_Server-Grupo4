package dao;

import java.util.List;

import data.Cancion;

public interface ICancionDAO {
	public List<Cancion> getCanciones();
	public Cancion getCanciones(String name);

}
