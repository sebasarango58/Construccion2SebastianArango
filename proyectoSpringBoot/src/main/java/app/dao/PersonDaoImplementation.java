/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;


import app.dao.interfaces.PersonDao;
import app.dao.repository.PersonRepository;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;
import jakarta.persistence.Entity;
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
public class PersonDaoImplementation implements PersonDao {
    @Autowired
    PersonRepository personRepository;
    
    @Override
	public boolean existsByDocument(PersonDto personDto) throws Exception {
		return personRepository.existsByDocument(personDto.getDocument());
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
                Person person = Helper.parse(personDto);
                personRepository.save(person);
	
	}

	@Override
	public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		personRepository.delete(person);
                personDto.setId(person.getId());
         
        }

	@Override
	public PersonDto findByDocument(PersonDto personDto) throws Exception {
            Person person = personRepository.findByDocument(personDto.getDocument());
		return Helper.parse(person);
	}

   
   

}

    
    
    

