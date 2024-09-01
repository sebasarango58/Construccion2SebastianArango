/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.config.MYSQLConnection;
import app.dao.interfaces.PersonDao;
import app.dto.PersonDto;
import app.helpers.Helper;
import app.model.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian
 */
public class PersonDaoImplementation implements PersonDao {
    
    @Override
	public boolean existsbyDocument(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getDocument());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		String query = "INSERT INTO PERSON(NAME,DOCUMENT,AGE) VALUES (?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getId());
                preparedStatement.setLong(2,personDto.getDocument());
                preparedStatement.setString(3, personDto.getName());
		preparedStatement.setLong(4, personDto.getCellphone());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		String query = "DELETE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,person.getDocument());
		preparedStatement.execute();
		preparedStatement.close();	
        
        }

	@Override
	public PersonDto findbyUserId(PersonDto personDto) throws Exception {
		String query = "SELECT ID,NAME,DOCUMENT,AGE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getDocument());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Person person = new Person();
			person.setId(resulSet.getLong("ID"));
			person.setName(resulSet.getString("NAME"));
			person.setDocument(resulSet.getLong("DOCUMENT"));
			person.setCellphone(resulSet.getInt("CELPHONE"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

   

}

    
    
    

