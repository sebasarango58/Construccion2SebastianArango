/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;


import app.dto.PersonDto;
import app.dto.UserDto;

/**
 *
 * @author Sebastian
 */
public interface UserDao {
    public UserDto findbyUserName (UserDto userDto) throws Exception;
    public boolean existsbyUserName(UserDto userDto) throws Exception;
    public UserDto findbyUserId (UserDto userDto) throws Exception;
    public void createUser (UserDto userDto) throws Exception;
    //public void updateUser (UserDto userDto) throws Exception;
    public void deleteUser (UserDto UserDto) throws Exception;
    
    
}
