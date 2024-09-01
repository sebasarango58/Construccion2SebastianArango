/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.config.MYSQLConnection;
import app.dao.interfaces.GuestDao;
import app.dto.GuestDto;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import app.model.Partner;
import app.model.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian
 */
public class GuestDaoImplementation implements GuestDao {
    
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
	public void createGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		String query = "INSERT INTO GUEST(USERID; PARTNERID, STATUS) VALUES (?,?,?) "; //Hecho por profe
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guest.getUserId().getId());
                preparedStatement.setLong(2, guest.getPartnerId().getId());
		preparedStatement.setString(3, String.valueOf(guest.isStatus()));
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void deleteGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		String query = "DELETE FROM GUEST WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,guest.getId());
		preparedStatement.execute();
		preparedStatement.close();	
        }
        
       /*
	@Override
	public PartnerDto findbyUserId(UserDto userDto) throws Exception {
		String query = "SELECT ID,USERID, AMOUNT TYPE CREATION DATE WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, userDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Partner partner = new Partner();
			partner.setId(resulSet.getLong("ID"));
			partner.setUserId((User) resulSet.getObject("USER ID"));
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

    public GuestDto findbyUserId(PersonDto personDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public void updateGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   */

    public GuestDto findbyUserId(PersonDto personDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateGuest(GuestDto guestDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
