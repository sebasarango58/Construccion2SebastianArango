/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;


import app.dao.interfaces.GuestDao;
import app.dao.repository.GuestRepository;
import app.dto.GuestDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Guest;
import app.model.User;
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
public class GuestDaoImplementation implements GuestDao {
    @Autowired
    GuestRepository guestRepository;
    
    public boolean existsByUserId(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
                return guestRepository.existsByUserId(user);
	
	}
    
        @Override
        public GuestDto findByUserId(UserDto userDto) throws Exception {
            User user = Helper.parse(userDto);
            Guest guest= guestRepository.findByUserId(user);
	return Helper.parse(guest);
        
        }
         
        @Override
	public void createGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		guestRepository.save(guest);
	}

	@Override
	public void deleteGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		guestRepository.delete(guest);	
        }
 
	
        @Override
	public void updateGuest(GuestDto guestDto) throws Exception {
                Guest guest = Helper.parse(guestDto);
                guestRepository.save(guest);
        }

}
