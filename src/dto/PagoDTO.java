/**********************************************************************
Copyright (c) 2017 Annonymous: ¿OB, AG, IG & PV? 
 **********************************************************************/
package dto;

import java.io.Serializable;

public class PagoDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private int numCuenta;
	private String passPayPal;
	
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getPassPayPal() {
		return passPayPal;
	}
	public void setPassPayPal(String passPayPal) {
		this.passPayPal = passPayPal;
	}

}
