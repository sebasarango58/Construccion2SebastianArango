/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.config.MYSQLConnection;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Partner;
import app.model.Person;
import app.model.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian
 */
public class PartnerDaoImplementation implements PartnerDao {
 
    @Override
	public boolean existsbyUserId(UserDto userDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE ID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, userDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}
         
        @Override
	public void createPartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
		String query = "INSERT INTO PERSON(ID, AMOUNT, TYPE) VALUES (?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, partner.getId());
                preparedStatement.setDouble(2, partner.getAmount());
		preparedStatement.setString(3, partner.getType());
                preparedStatement.setDate(4, (Date) partner.getCreation_date());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void deletePartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
		String query = "DELETE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,partner.getId());
		preparedStatement.execute();
		preparedStatement.close();	
        }
        
       
	@Override
	public PartnerDto findbyUserId(UserDto userDto) throws Exception {
		String query = "SELECT ID,USERID, AMOUNT, TYPE, CREATION DATE WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, userDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Partner partner = new Partner();
			partner.setId(resulSet.getLong("ID"));
			partner.setUserId((User) resulSet.getObject("USERID"));
			partner.setAmount(resulSet.getDouble("AMOUNT"));
                        partner.setType(resulSet.getString("TYPE"));
			partner.setCreation_date(resulSet.getDate("CREATION DATE"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(partner);
		}
		resulSet.close();
                    preparedStatement.close();
		return null;
	}

        @Override
	public void updatePartner(PartnerDto partnerDto) throws Exception {
                Partner partner = Helper.parse(partnerDto);
                String query = "UPDATE TABLE PARTNER AMOUNT,TYPE WHERE ID =(?) ";
                PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
                preparedStatement.setDouble(1, partner.getAmount());
                preparedStatement.setString(2, partner.getType());
                preparedStatement.setLong(3, partner.getId());
                preparedStatement.execute();
		preparedStatement.close();
                
        }
    

    
}
