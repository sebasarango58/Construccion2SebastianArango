/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Sebastian
 */
public class InvoiceValidator extends CommonsValidator {
    
    public InvoiceValidator() {
		super();
	}
	
	public void validItems(String items)throws Exception {
		super.isValidString("items de la factura: ", items);
	}
	
	public double validTotalAmount(String totalAmount) throws Exception{
		return super.isValidDouble("Total de la factura: ", totalAmount);
	}
    
    
}
