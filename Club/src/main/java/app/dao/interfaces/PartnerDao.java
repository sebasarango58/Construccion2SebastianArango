/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.PartnerDto;
import app.dto.UserDto;

/**
 *
 * @author Sebastian
 */
public interface PartnerDao {
    public boolean existsbyUserId(UserDto userDto) throws Exception;
    public PartnerDto findbyUserId(UserDto userDto) throws Exception;
    public void createPartner(PartnerDto partnerDto) throws Exception;
    public void updatePartner (PartnerDto partnerDto) throws Exception;
    public void deletePartner(PartnerDto partnerDto) throws Exception;
    

    
}
