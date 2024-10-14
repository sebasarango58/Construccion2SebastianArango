/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service.interfaces;

import app.dto.UserDto;

/**
 *
 * @author Sebastian
 */
public interface UserService {
    public void createUser(UserDto userDto) throws Exception;
}
