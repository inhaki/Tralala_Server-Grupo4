/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class ListaRepr implements Serializable{
	
	private String nomList;
	private int idLista;
	private String descrip;
	private Usuario user;
	//una canción puede estar en N listas y
	//una lista puede contener M canciones
	@Persistent(defaultFetchGroup="true")
	private Cancion cancion;
	

}
