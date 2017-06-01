package utils;

import data.Pago;
import dto.PagoDTO;

public class PagoAssembler {
	
	//esta clase es Singleton
	//utilizaremos el método Lazy
	private static PagoAssembler instance;
	
	public static PagoAssembler getInstance(){
		if (instance == null) {
			instance = new PagoAssembler();
		}

		return instance;
	}
	
	public PagoDTO entityToDTO(Pago pago){
		PagoDTO dto = new PagoDTO();
		
		dto.setNumCuenta(pago.getNumCuenta());
		dto.setPassPayPal(pago.getPassPayPal());
		
		return dto;
	}

}
