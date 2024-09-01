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

/**
 *
 * @author Sebastian
 */
public class PartnerController implements ControllerInterface{
        private PersonValidator personValidator;
	private UserValidator userValidator;
	private InvoiceValidator invoiceValidator;
        private GuestValidator guestValidator;
        private DetailInvoiceValidator detailInvoiceValidator;
        private static final String MENU = 
                "Ingrese la opcion la accion que desea hacer \n 1. Crear socio. \n 2. Cancelar Suscripción \n 3. para cerrar sesion";


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
        public PartnerController() {
		this.personValidator = new PersonValidator();
		this.invoiceValidator = new InvoiceValidator();
		this.guestValidator= new GuestValidator();
		this.detailInvoiceValidator = new DetailInvoiceValidator();
        }
}

	
        

             
        
        
   

        
    

