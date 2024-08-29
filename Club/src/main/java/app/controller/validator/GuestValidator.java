/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Sebastian
 */
public class GuestValidator extends CommonsValidator {
    
    public GuestValidator() {
		super();
	}
	
	public long validId(String id) throws Exception{
		return super.isValidLong("id del invitado: ", id);
        }
	public boolean validType(String type) {
        try {
        super.isValidDouble("Estado del invitado: ", type);
        return true; // Si la validaci�n es exitosa
        
        } catch (Exception e) {
        return false; // Si ocurre una excepci�n durante la validaci�n
        }
        }
    
}
