/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

public class Reproduccion {
	
	private String fecha;
	private double hora;
	//un entero que irá incrementando según las reproducciones que se hagan
	private int reproduccion;
	
	//una reproducción en una fecha determinada y hora exacta, pertenecerá a una única canción
	private Cancion cancion;
	//también será de una sola persona
	//Relación 1(Usuario) a N(Reproducciones)
	private Usuario usuario;

}
