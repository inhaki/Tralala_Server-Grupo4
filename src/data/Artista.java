/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.util.List;

public class Artista {
	
	private String nombre;
	private int idArtista;
	private String pais;
	
	//relaci�n con la clase Grupo de N a M
	//un grupo puede estar formado por uno o m�s artistas
	//y un artista puede estar en uno o m�s grupos
	private List<Grupo> listaGrupo;

}
