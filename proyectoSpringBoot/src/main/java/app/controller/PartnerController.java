/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.validator.DetailInvoiceValidator;
import app.controller.validator.GuestValidator;
import app.controller.validator.InvoiceValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Sebastian
 */
@Controller
@Setter
@Getter
@NoArgsConstructor
public class PartnerController implements ControllerInterface{
        @Autowired
        private PersonValidator personValidator;
        @Autowired
	private UserValidator userValidator;
        @Autowired
	private InvoiceValidator invoiceValidator;
        @Autowired
        private GuestValidator guestValidator;
        @Autowired
        private DetailInvoiceValidator detailInvoiceValidator;
        
        private static final String MENU = 
                "Ingrese la opcion la accion que desea hacer \n "
                + "1. Crear socio. \n "
                + "2. Cancelar Suscripci�n \n "
                + "3. para cerrar sesion";


    @Override
    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = PartnerSession();
		}

}
    
    private boolean PartnerSession() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private boolean menu(String option) throws Exception {
		switch (option) {
		
		case "1": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
}
        
                
  }
        
}

	
        

             
        
        
   

        
    

