package dao;

import data.Usuario;
import java.util.List;

public interface ITralalaDAO {
	//tiene los métodos que la clase UsuarioDAO implementa
	public void registrarUsuario(Usuario user);
	public List<Usuario> getUsuarios();
}
