/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class PartnerValidator extends CommonsValidator{
    
    public PartnerValidator() {
		super();
	}
	
	public long validId(String id) throws Exception{
		return super.isValidLong("id del socio: ", id);
	}
        public double validAmount(String amount) throws Exception{
		return super.isValidDouble("Fondos Disponibles: ", amount);
	}
        public boolean validType(String type) {
        try {
        super.isValidDouble("Tipo de Suscripcion: ", type);
        return true; // Si la validación es exitosa
        
        } catch (Exception e) {
        return false; // Si ocurre una excepción durante la validación
        }
        }
        public Date validDate(String creation_date) throws Exception{
		return super.isValidDate("Fecha de Afiliación: ", creation_date);
	}
        
	

}

    
