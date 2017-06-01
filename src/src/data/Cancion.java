/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Join;

@PersistenceCapable(detachable = "true")
public class Cancion implements Serializable{
	
	private String titulo;
	private double duracion;
	private String fechaLanz;
	private int precio;
	private String letra;
	private String genero;
	
	//relación N a M entre lista y cancion
	@Persistent(defaultFetchGroup="true")
	@Join
	private List<ListaRepr> listaR;
	
	//una cacnión puede ser reproduccida N veces
	//esta lista contabiliza las reproducciones de cada canción
	private List<Reproduccion> listRepCancion;
	
	public Cancion(String titulo, double duracion, String fechaLanz,
			int precio, String letra, String genero) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.fechaLanz = fechaLanz;
		this.precio = precio;
		this.letra = letra;
		this.genero = genero;
		this.listaR= new ArrayList<ListaRepr>();
		this.listRepCancion = new ArrayList<Reproduccion>();
	}
	
	
}
