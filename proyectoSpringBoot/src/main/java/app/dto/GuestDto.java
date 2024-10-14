/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sebastian
 */
@Setter
@Getter
@NoArgsConstructor
public class GuestDto {
    private long id;
    private UserDto userId;
    private PartnerDto partnerId;
    private boolean status;



}
