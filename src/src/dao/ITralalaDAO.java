package dao;

import data.Cancion;
import data.Usuario;

import java.util.List;

public interface ITralalaDAO {
	//tiene los métodos que la clase UsuarioDAO implementa
	public void registrarUsuario(Usuario user);
	public List<Usuario> getUsuarios();
	public List<Cancion> getCanciones();
	public Cancion getCanciones(String name);
}
