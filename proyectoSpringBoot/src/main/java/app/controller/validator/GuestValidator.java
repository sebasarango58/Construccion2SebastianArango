/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

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
public class GuestValidator extends CommonsValidator {
    
	public long validId(String id) throws Exception{
		return super.isValidLong("Id del invitado: ", id);
        }
	public boolean validType(String type) {
        try {
        super.isValidDouble("Tipo de invitado: ", type);
        return true; // Si la validaci�n es exitosa
        
        } catch (Exception e) {
        return false; // Si ocurre una excepci�n durante la validaci�n
        }
        }
    
}
