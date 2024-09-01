/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.config.MYSQLConnection;
import app.dao.interfaces.UserDao;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Person;
import app.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Sebastian
 */
public class UserDaoImplementation implements UserDao {
    
    @Override
	public UserDto findbyUserName(UserDto userDto) throws Exception {
		String query = "SELECT ID,USERNAME,PASSWORD,ROLE,PERSONID FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUsername());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			User user = new User();
			user.setId(resulSet.getLong("ID"));
			user.setUsername(resulSet.getString("USERNAME"));
			user.setPassword(resulSet.getString("PASSWORD"));
			user.setRole(resulSet.getString("ROLE"));
			Person person = new Person();
			person.setDocument(resulSet.getLong("PERSONID"));
			user.setPersonId(person);
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(user);
		}
		resulSet.close();
		preparedStatement.close();
		return null;

	}

	@Override
	public boolean existsbyUserName(UserDto userDto) throws Exception {
		String query = "SELECT 1 FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUsername());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
		}

	@Override
	public void createUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		String query = "INSERT INTO USER(Id,USERNAME,PASSWORD,PERSONID,ROLE) VALUES (?,?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setLong(3,user.getPersonId().getId());
		preparedStatement.setString(4, user.getRole());
		preparedStatement.execute();
		preparedStatement.close();
		}
        
        @Override
        public UserDto findbyUserId(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		String query = "INSERT INTO USER(ID, USERNAME,PASSWORD,PERSONID,ROLE) VALUES (?,?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setLong(3,user.getPersonId().getId());
		preparedStatement.setString(4, user.getRole());
		preparedStatement.execute();
		preparedStatement.close();
                return Helper.parse(user);
		}
        
        @Override
	public void deleteUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		String query = "DELETE FROM USER WHERE ID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,user.getId());
		preparedStatement.execute();
		preparedStatement.close();	
        
       }

 
}
