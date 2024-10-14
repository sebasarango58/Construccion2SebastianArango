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
public class GuestController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
	private UserValidator userValidator;
    @Autowired
	private InvoiceValidator invoiceValidator;
    @Autowired
        private PartnerValidator partnerValidator;
    @Autowired
        private DetailInvoiceValidator detailInvoiceValidator;
        private static final String MENU = 
                "Ingrese la opcion la accion que desea hacer \n 1. Crear invitado \n 2. Dar de baja al invitado \n 3. para cerrar sesion";
        
        
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

