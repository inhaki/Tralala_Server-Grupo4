/**********************************************************************
Copyright (c) 2017 Annonymous: �OB, AG, IG & PV? 
 **********************************************************************/
package data;

public class Reproduccion {
	
	private String fecha;
	private double hora;
	//un entero que ir� incrementando seg�n las reproducciones que se hagan
	private int reproduccion;
	
	//una reproducci�n en una fecha determinada y hora exacta, pertenecer� a una �nica canci�n
	private Cancion cancion;
	//tambi�n ser� de una sola persona
	//Relaci�n 1(Usuario) a N(Reproducciones)
	private Usuario usuario;

}
