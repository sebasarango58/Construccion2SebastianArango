/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.GuestDto;
import app.dto.PersonDto;
import app.dto.UserDto;

/**
 *
 * @author Sebastian
 */
public interface GuestDao {
    public boolean existsByUserId (UserDto userDto) throws Exception;
    public GuestDto findByUserId (UserDto userDto) throws Exception;
    public void createGuest(GuestDto guestDto) throws Exception;
    public void updateGuest (GuestDto guestDto) throws Exception;
    public void deleteGuest (GuestDto guestDto) throws Exception;
    //public void findById (GuestDto guestDto) throws Exception;
    
    
}
