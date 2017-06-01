/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.util.List;

public class Grupo {
	
	private int id;
	private String nombre;
	
	//una canción solo puede estar compuesta por un grupo
	private Cancion cancion;
	
	//N a M con Artista
	private List<Artista> listaArtista;

}
