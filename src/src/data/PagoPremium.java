/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package data;

public class PagoPremium extends Pago{
	
	public PagoPremium(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	
	//calcular cantidad a pagar
	private double PagoPremium(Double cantidad){
		
		//haríamos una conversión de la cantidad de reproducciones
		//sumamos la cantidad fija, por ejemplo 1000
		//mas el 2% del las reproducciones
		//cantidad=1000+(2%*usuario.getListaR());
		
		return cantidad;
		
	}

}
