/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Join;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Usuario {
	
	protected String nombre;
	protected int idUser;
	protected String email;
	protected String contrase�a;
	protected String dni;
	// 1 to N bidirectional association and delete on cascade for copies
	// default-fetch-group so when User is retrieved from db, lists will be retrieved as well
	//cuando internamente manejamos atributos no primitivos y queremos sacarlos, hay que usar
	//defaultFetchGroup= true
	@Persistent(defaultFetchGroup="true", mappedBy="usuario", dependentElement = "true")
	@Join
	private List<ListaRepr> listaR;
	public Usuario(String nombre, int idUser, String email, String contrase�a,
			String dni) {
		//LO COMENTO PARA QUE COINCIDA CON EL M�TODO EN DBManager
		super();
		this.nombre = nombre;
		this.idUser = idUser;
		this.email = email;
		this.contrase�a = contrase�a;
		this.dni = dni;
		this.listaR = new ArrayList<ListaRepr>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	
	public boolean checkContrase�a(String contrase�a)
	{
		return this.contrase�a.equals(contrase�a);
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<ListaRepr> getListaR() {
		return listaR;
	}
	public void setListaR(List<ListaRepr> listaR) {
		this.listaR = listaR;
	}
	
	
	
}