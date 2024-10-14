/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastian
 */
@Setter
@Getter
@NoArgsConstructor
@Component
public class PartnerValidator extends CommonsValidator{
	
	public long validId(String id) throws Exception{
		return super.isValidLong("id del socio: ", id);
	}
        public double validAmount(String amount) throws Exception{
		return super.isValidDouble("Fondos Disponibles: ", amount);
	}
        public boolean validType(String type) {
        try {
        super.isValidDouble("Tipo de Suscripcion: ", type);
        return true; // Si la validaci�n es exitosa
        
        } catch (Exception e) {
        return false; // Si ocurre una excepci�n durante la validaci�n
        }
        }
        public Date validDate(String creation_date) throws Exception{
		return super.isValidDate("Fecha de Afiliación: ", creation_date);
	}
        
	

}

    
