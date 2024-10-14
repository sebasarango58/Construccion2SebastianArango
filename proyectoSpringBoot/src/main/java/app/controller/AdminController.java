/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.interfaces.AdminService;
import java.util.Date;
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
public class AdminController implements ControllerInterface{
    @Autowired
        private PersonValidator personValidator;
    @Autowired
        private UserValidator userValidator;
    @Autowired
        private AdminService service;
        private static final String MENU = "Ingrese la opción que desea \n "
                + "1. Para crear Socio \n "
                + "2. para crear el invitado \n "
                + "3. Para cerrar sesion";
        

        @Override 
        public void session() throws Exception{
            boolean session =true;
            while (session){
                session = menu();
            }
        }
        private boolean menu(){
            try{  
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
            
            }catch(

		Exception e) {
			System.out.println(e.getMessage());
			return true;
            }            
        }
            
            
        private boolean options(String option)throws Exception{    
            switch (option){
            case "1" :{
                this.createPartner();
                return true;
            }
            case "2" :{
                this.createGuest();
                return true;
            }
            case "3" :{
                System.out.println("Se ha cerrado Sesion");
                return false;
            }
            default :  {
                System.out.println("Ingrese una opci�n valida");
                return true;
            }
            }

}         

        private void createPartner() throws Exception{
               System.out.println("Ingrese nombre del socio");
               String name = Utils.getReader().nextLine();
               personValidator.validName(name);
               System.out.println("Ingrese la C�dula del socio");
               long document = personValidator.validDocument(Utils.getReader().nextLine());
               System.out.println("Ingrese el n�mero celular del socio");
               long cellphone = personValidator.validCellphone(Utils.getReader().nextLine());
               System.out.println("ingrese el nombre de usuario del socio");
               String userName = Utils.getReader().nextLine();
               userValidator.validUserName(userName);
               System.out.println("ingrese la contrase�a del socio");
               String password = Utils.getReader().nextLine();
               userValidator.validPassword(password);
               PersonDto personDto = new PersonDto();
               personDto.setName(name);
               personDto.setDocument(document);
               personDto.setCellphone(cellphone);
               UserDto userDto = new UserDto();
               userDto.setPersonId(personDto);
               userDto.setUsername(userName);
               userDto.setPassword(password);
               userDto.setRole("Partner");
               PartnerDto partnerDto = new PartnerDto();
               partnerDto.setUserId(userDto);
               partnerDto.setType("Regular"); /////////////validar
               partnerDto.setAmount(50000);
               partnerDto.setCreation_date(new Date(System.currentTimeMillis()));  
               this.service.createPartner(partnerDto);
               System.out.println("Se ha creado el usuario correctamente");
    
    
        }

        private void createGuest() throws Exception{
                System.out.println("ingrese el nombre del invitado");
                String name = Utils.getReader().nextLine();
                personValidator.validName(name);
                System.out.println("ingrese la cedula del invitado");
                long document = personValidator.validDocument(Utils.getReader().nextLine());
                System.out.println("ingrese el n�mero celular del invitado");
                long cellphone = personValidator.validCellphone(Utils.getReader().nextLine());
                System.out.println("ingrese el nombre de usuario del invitado");
                String userName = Utils.getReader().nextLine();
                userValidator.validUserName(userName);
                System.out.println("ingrese la contrase�a del invitado");
                String password = Utils.getReader().nextLine();
                userValidator.validPassword(password);
                PersonDto personDto = new PersonDto();
                personDto.setName(name);
                personDto.setDocument(document);
                personDto.setCellphone(cellphone);
                UserDto userDto = new UserDto();
                userDto.setPersonId(personDto);
                userDto.setUsername(userName);
                userDto.setPassword(password);
                userDto.setRole("Guest");
                GuestDto guestDto = new GuestDto();
                guestDto.setUserId(userDto);
                this.service.createGuest(guestDto);
                System.out.println("Se ha creado el usuario correctamente");
        }

 //create Invoice
   //un metodo que permita visualizar facturas
}
