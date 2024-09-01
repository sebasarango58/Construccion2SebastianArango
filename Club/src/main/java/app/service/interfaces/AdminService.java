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
public interface AdminService {
    public void createParner(UserDto userDto) throws Exception;
    public void createGuest(UserDto userDto) throws Exception;
    
}
