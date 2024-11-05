/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.request.CreateGuestRequest;
import app.controller.request.CreatePartnerRequest;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Sebastian
 */
@RestController
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
        
        }
        
        @GetMapping("/partner")
        public String funcion(){
            return "Funciona";
        }
        
        @GetMapping("/guest")
        public String funciona(){
            return "Guest Funciona";
        }
        
        
        @PostMapping("/partner")
        private ResponseEntity createPartner(@RequestBody CreatePartnerRequest request) throws Exception{
            try{
               
               String name = request.getName();
               personValidator.validName(name);
               long document = personValidator.validDocument(request.getDocument());
               long cellphone = personValidator.validCellphone(request.getCellphone());
               String userName = request.getUserName();
               userValidator.validUserName(userName);
               String password = request.getPassword();
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
               return new ResponseEntity<>("Se ha creado el usuario correctamente",HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
                
    
        }
        @PostMapping("/guest")
        private ResponseEntity createGuest(@RequestBody CreateGuestRequest request) throws Exception{
            try{
                
                String name = request.getName();
                personValidator.validName(name);
                long document = personValidator.validDocument(request.getDocument());
                long cellphone = personValidator.validCellphone(request.getCellphone());  
                String userName = request.getUserName();
                userValidator.validUserName(userName);
                String password = request.getPassword();
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
                return new ResponseEntity<>("Se ha creado el usuario correctamente",HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
}

 //create Invoice
   //un metodo que permita visualizar facturas
}
