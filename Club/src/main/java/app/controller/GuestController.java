/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.validator.DetailInvoiceValidator;
import app.controller.validator.InvoiceValidator;
import app.controller.validator.PartnerValidator;
import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;

/**
 *
 * @author Sebastian
 */
public class GuestController implements ControllerInterface{
    
    private PersonValidator personValidator;
	private UserValidator userValidator;
	private InvoiceValidator invoiceValidator;
        private PartnerValidator partnerValidator;
        private DetailInvoiceValidator detailInvoiceValidator;
        private static final String MENU = 
                "Ingrese la opcion la accion que desea hacer \n 1. Crear invitado \n 2. Dar de baja al invitado \n 3. para cerrar sesion";
        
        public GuestController() {
                this.personValidator = new PersonValidator();
		this.userValidator = new UserValidator();
                this.invoiceValidator = new InvoiceValidator();
                this.partnerValidator = new PartnerValidator();
		this.detailInvoiceValidator = new DetailInvoiceValidator();
	}
        
        public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}
    
}
        private boolean menu() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			this.createPartner();
			return true;
		}
		case "2": {
			this.deletePartner();
			return true;
		
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
                }
        }
        private void createPartner() throws Exception {
	}

	private void deletePartner() throws Exception {
	}

	
                
}

