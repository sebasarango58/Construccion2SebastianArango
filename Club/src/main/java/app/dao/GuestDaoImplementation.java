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
	public GuestDto findbyGuestId (GuestDto guestDto) throws Exception {
		String query = "SELECT ID,USERID, PARTNERID, STATUS WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guestDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Guest guest = new Guest();
			guest.setId(resulSet.getLong("ID"));
			guest.setUserId((User) resulSet.getObject("USERID"));
			guest.setPartnerId((Partner) resulSet.getObject("PARTNERID"));
                        guest.setStatus(guest.isStatus("STATUS"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(guest);
		}
		resulSet.close();
                preparedStatement.close();
		return null;
	}
*/
        @Override
	public void updateGuest(GuestDto guestDto) throws Exception {
                Guest guest = Helper.parse(guestDto);
                String query = "UPDATE GUEST STATUS WHERE ID =(?) ";
                PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
                preparedStatement.setBoolean(1, guest.isStatus());
                preparedStatement.setLong(2, guest.getId());
                preparedStatement.execute();
		preparedStatement.close();
                
        }
}
