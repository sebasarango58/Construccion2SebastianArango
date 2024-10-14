/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;


import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.repository.PartnerRepository;
import app.dao.repository.PersonRepository;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Partner;
import app.model.Person;
import app.model.User;
import jakarta.persistence.Entity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@NoArgsConstructor
@Service
public class PartnerDaoImplementation implements PartnerDao {
    @Autowired
    PartnerRepository partnerRepository;
 
    @Override
	public boolean existsByUserId(UserDto userDto) throws Exception {
	    User user = Helper.parse(userDto);
            return partnerRepository.existsByUserId(user);
	}
         
        @Override
	public void createPartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
                partnerRepository.save(partner);
                
   
	}

	@Override
	public void deletePartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
                partnerRepository.delete(partner);
              
        }
        
       
	@Override
	public PartnerDto findByUserId(UserDto userDto) throws Exception {
            User user = Helper.parse(userDto);
            Partner partner= partnerRepository.findByUserId(user);
	return Helper.parse(partner);
          
	}

        @Override
	public void updatePartner(PartnerDto partnerDto) throws Exception {
                Partner partner = Helper.parse(partnerDto);
                partnerRepository.save(partner);
                
        }
    

    
}
