/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
**********************************************************************/
package data;

public class Pago {
	
	protected Usuario usuario;
	protected double cantidad;//para coger el dato del arrayList y pasarlo a double
	protected int reproducciones;//pasar el dato correspondiente a numero de rep
	protected String passPayPal;//en algunos usuarios, bien PayPal o numCuenta serán nulos
	
	public Pago (Usuario usuario){
		this.usuario= usuario;
	}
	
	public String getPassPayPal() {
		return passPayPal;
	}

	public void setPassPayPal(String passPayPal) {
		this.passPayPal = passPayPal;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	protected int numCuenta;

}
