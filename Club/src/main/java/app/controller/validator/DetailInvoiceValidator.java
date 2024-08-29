/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Sebastian
 */
public class DetailInvoiceValidator extends CommonsValidator{
    
    public DetailInvoiceValidator() {
		super();
	}
	
	public void validDescription(String description) throws Exception{
		super.isValidString("el nombre de la persona ", description);
	}
	
	public double validDocument(String amount) throws Exception{
		return super.isValidDouble("la cedula de la persona ", amount);
	}
	
	public int validItem(String item) throws Exception{
		return super.isValidInteger("la edad de la persona ", item);
	}
}
