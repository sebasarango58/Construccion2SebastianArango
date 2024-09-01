/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.helpers;

import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Guest;
import app.model.Invoice;
import app.model.Partner;
import app.model.Person;
import app.model.User;

/**
 *
 * @author Sebastian
 */
public abstract class Helper {
    
        public static PersonDto parse(Person person) {
	        PersonDto personDto = new PersonDto();
	        personDto.setId(person.getId());
	        personDto.setDocument(person.getDocument());
	        personDto.setName(person.getName());
	        personDto.setCellphone(person.getCellphone());
	        return personDto;
                
        }
        
        public static Person parse(PersonDto personDto) {
	        Person person = new Person();
		person.setId(personDto.getId());
		person.setDocument(personDto.getDocument());
		person.setName(personDto.getName());
		person.setCellphone(personDto.getCellphone());
		return person;
        }        
                
        public static UserDto parse(User user) {
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setPassword(user.getPassword());
                userDto.setPersonId(parse(user.getPersonId()));
                userDto.setRole(user.getRole());
                userDto.setUsername(user.getUsername());
                return userDto;
        }
        
        public static User parse(UserDto userDto) {
	        User user = new User();
		user.setId(user.getId());
                user.setPassword(user.getPassword());
                user.setPersonId(parse(userDto.getPersonId()));
                user.setRole(user.getRole());
                user.setUsername(user.getUsername());
                return user;
        }       
        
        public static PartnerDto parse(Partner partner){
                PartnerDto partnerDto = new PartnerDto();
                partnerDto.setId(partner.getId());
                partnerDto.setUserId(parse(partner.getUserId()));
                partnerDto.setAmount(partner.getAmount());
                partnerDto.setType(partner.getType());
                partnerDto.setCreation_date(partner.getCreation_date());
                return partnerDto;
        }        
    
        public static Partner parse(PartnerDto partnerDto){
                Partner partner = new Partner();
                partner.setId(partnerDto.getId());
                partner.setUserId(parse(partnerDto.getUserId()));
                partner.setAmount(partnerDto.getAmount());
                partner.setType(partnerDto.getType());
                partner.setCreation_date(partnerDto.getCreation_date());
                return partner;        
            
        }
        
        public static GuestDto parse(Guest guest){
                GuestDto guestDto = new GuestDto();
                guestDto.setId(guest.getId());
                guestDto.setUserId(parse(guest.getUserId()));
                guestDto.setPartnerId(parse(guest.getPartnerId()));
                guestDto.setStatus(guest.isStatus());
                return guestDto; 
        }
        
        public static Guest parse(GuestDto guestDto){
                Guest guest = new Guest();
                guest.setId(guestDto.getId());
                guest.setUserId(parse(guestDto.getUserId()));
                guest.setPartnerId(parse(guestDto.getPartnerId()));
                guest.setStatus(guest.isStatus());
                return guest;        
            
        }
               
}
    
