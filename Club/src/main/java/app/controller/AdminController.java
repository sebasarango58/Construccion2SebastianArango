/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.controller.validator.PersonValidator;
import app.controller.validator.UserValidator;
import app.dto.PersonDto;
import app.dto.UserDto;


/**
 *
 * @author Sebastian
 */
public class AdminController implements ControllerInterface{
    private PersonValidator personValidator;
    private UserValidator userValidator;
  
    public AdminController(){
        this.personValidator = new PersonValidator ();
        
}

@Override 
public void session() throws Exception{
    
}

public void createPartner() throws Exception{
    System.out.println("Ingrese nombre del socio");
    String name = Utils.getReader().nextLine();
    personValidator.validName(name);
    System.out.println("Ingrese la Cédula del socio");
    long document = personValidator.validDocument(Utils.getReader().nextLine());
    System.out.println("Ingrese el número celular del socio");
    long cellphone = personValidator.validCellphone(Utils.getReader().nextLine());
    System.out.println("ingrese el nombre de usuario del socio");
    String userName = Utils.getReader().nextLine();
    userValidator.validUserName(userName);
    System.out.println("ingrese la contraseña del socio");
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
    
    System.out.println("Se ha creado el usuario correctamente");
    
    
    
}

private void createGuest() throws Exception {
    System.out.println("ingrese el nombre del invitado");
    String name = Utils.getReader().nextLine();
    personValidator.validName(name);
    System.out.println("ingrese la cedula del invitado");
    long document = personValidator.validDocument(Utils.getReader().nextLine());
    System.out.println("ingrese el número celular del invitado");
    long cellphone = personValidator.validCellphone(Utils.getReader().nextLine());
    System.out.println("ingrese el nombre de usuario del invitado");
    String userName = Utils.getReader().nextLine();
    userValidator.validUserName(userName);
    System.out.println("ingrese la contraseña del invitado");
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
  
    System.out.println("Se ha creado el usuario correctamente");
}


}
