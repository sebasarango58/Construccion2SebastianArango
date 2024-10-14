/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;


import app.dao.interfaces.DetailInvoiceDao;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.InvoiceDao;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dto.DetailInvoiceDto;
import app.dto.GuestDto;
import app.dto.InvoiceDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.service.interfaces.AdminService;
import app.service.interfaces.GuestService;
import app.service.interfaces.InvoiceService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartnerService;
import app.service.interfaces.PersonService;
import app.service.interfaces.UserService;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Getter
@Setter
@Service
@NoArgsConstructor
public class ClubService implements LoginService, AdminService, PartnerService, GuestService, PersonService, UserService, InvoiceService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private GuestDao guestDao;
    @Autowired
    private DetailInvoiceDao detailInvoiceDao;
    @Autowired

    public static UserDto user;



    @Override
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if (validateDto == null) {
            throw new Exception("no existe usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRole(validateDto.getRole());
        user = validateDto;

    }

    @Override
    public void logout() {
        user = null;
        System.out.println("Se ha cerrado Sesion");
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        if (this.userDao.existsByUserName(userDto)) {
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("Ya Existe un usuario con este nombre");
        }
        try{
           this.userDao.createUser(userDto);
        }catch (SQLException e) {
            this.personDao.deletePerson(userDto.getPersonId());
        }
    
    }
    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        if (this.personDao.existsByDocument(personDto)) {
            throw new Exception("Ya existe una persona con este documento");
        }
        this.personDao.createPerson(personDto);
    }
    
    public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        this.partnerDao.createPartner(partnerDto);
    }
 
    public void createGuest(GuestDto guestDto) throws Exception {
       /* PersonDto personDto = personDao.findByDocument(guestDto.getPartnerId());
        if (personDto == null) {
            throw new Exception("No existe un huesped registrado con esa cédula");
        }
        guestDto.setPartnerId(partnerId);
        guestDao.createGuest(guestDto);
        */
  
      
    }
 
    public void updateAmount(PartnerDto parnerDto) throws Exception {
        PartnerDto partnerDto = partnerDao.findByUserId(user);
        partnerDto.setAmount(parnerDto.getAmount() + partnerDto.getAmount());
        if (partnerDto.getType().equals("VIP") && partnerDto.getAmount() > 5000000) {
            throw new Exception("se han superado topes");
        }
        if (partnerDto.getType().equals("Regular") && partnerDto.getAmount() > 1000000) {
            throw new Exception("se han superado topes");
        }
    //validar que no se superen topes 

        this.partnerDao.updatePartner(partnerDto);

    }

    public void upgradeType(PartnerDto parnetDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void updateGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteGuest() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void createInvoice(InvoiceDto invoiceDto, DetailInvoiceDto detailInvoiceDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createGuest(UserDto userDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
