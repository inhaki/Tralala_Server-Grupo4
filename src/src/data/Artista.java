/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

import java.util.List;

public class Artista {
	
	private String nombre;
	private int idArtista;
	private String pais;
	
	//relación con la clase Grupo de N a M
	//un grupo puede estar formado por uno o más artistas
	//y un artista puede estar en uno o más grupos
	private List<Grupo> listaGrupo;

}
