/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import java.util.Date;
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
public class PartnerDto {
    private long id;
    private UserDto userId;
    private double amount;
    private String type;
    private Date creation_date;
    
    
}
