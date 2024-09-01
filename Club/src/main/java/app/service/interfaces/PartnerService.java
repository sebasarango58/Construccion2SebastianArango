/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service.interfaces;

import app.dto.PartnerDto;

/**
 *
 * @author Sebastian
 */
public interface PartnerService {
    public void createPartner(PartnerDto parnetDto) throws Exception;
    public void updateAmount(PartnerDto parnetDto) throws Exception;
    public void upgradeType(PartnerDto parnetDto) throws Exception;
    
}
