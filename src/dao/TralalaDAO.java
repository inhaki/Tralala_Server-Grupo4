/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import data.Usuario;

//DAO para las tablas en bbdd de Usuario y Canciones
//en lugar de hacer dos DAO, juntamos todos los m�todos en este
//<<Singleton>>
public class TralalaDAO implements ITralalaDAO{
	//muy importante implementar la interfaz
	private PersistenceManagerFactory pmf;
	
	private static TralalaDAO instance;
	
	public TralalaDAO(){
		
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	//m�todo que devuelve una instancia de UsuarioDAO
	//as� LoginService podr� hacer uso de ella e implementar el Login
	public static TralalaDAO getInstance() {
		
		if (instance == null){
			instance= new TralalaDAO();
		}
		
		return instance;
		
	}
	
	public void registrarUsuario(Usuario user){
		this.registrarUsuario(user);
	}
	
	//este m�todo no hace falta usarlo, sirve para 
	//devolver una lista con los usuarios que haya en el sistema
	//para las Canciones puede que sea interesante hacerlo y usarlo
	public List<Usuario> getUsuarios(){
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios= new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Usuarios.");
			
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			
			for (Usuario user : extent) {
				usuarios.add(user);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    //si no se hace el DefaultFetch... el return de products estar�a vac�o				
		return usuarios;
	}
	
	//Se podr�a a�adir un METODO 3 DE BORRAR usuarios
	//public void borrarUsuarios(){}
}
