package dao;

import data.Usuario;
import java.util.List;

public interface IUsuarioDAO {
	//tiene los m�todos que la clase UsuarioDAO implementa
	public void registrarUsuario(Usuario user);
	public List<Usuario> getUsuarios();
}
