/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service.interfaces;

import app.dto.GuestDto;
import app.dto.PartnerDto;

/**
 *
 * @author Sebastian
 */
public interface AdminService {
    public void createPartner(PartnerDto partnerDto) throws Exception;
    public void createGuest(GuestDto guestDto) throws Exception;
    
    
}
