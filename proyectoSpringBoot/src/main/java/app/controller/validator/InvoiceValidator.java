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
public class InvoiceValidator extends CommonsValidator {
    

	public void validItems(String items)throws Exception {
		super.isValidString("items de la factura: ", items);
	}
	
	public double validTotalAmount(String totalAmount) throws Exception{
		return super.isValidDouble("Total de la factura: ", totalAmount);
	}
    
    
}
