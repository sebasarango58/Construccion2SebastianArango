/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;


import app.dao.interfaces.UserDao;
import app.dao.repository.UserRepository;
import app.dto.UserDto;
import app.helpers.Helper;
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
public class UserDaoImplementation implements UserDao {
    @Autowired
    UserRepository userRepository;
    
    @Override
	public UserDto findByUserName(UserDto userDto) throws Exception {
            User user = userRepository.findByUsername(userDto.getUsername());
                return Helper.parse(user);   
	}

	@Override
	public boolean existsByUserName(UserDto userDto) throws Exception {
            return userRepository.existsByUsername(userDto.getUsername());
            
        }
    
	@Override
	public void createUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
                userRepository.save(user);
        }
        
        @Override
        public UserDto findByUserId(UserDto userDto) throws Exception {
                User user = userRepository.findById(userDto.getId());
		return Helper.parse(user);
        }
   
        @Override
	public void deleteUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
                userRepository.delete(user);

	}
 
}
