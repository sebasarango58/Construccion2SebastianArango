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
public class InvoiceDto {
    private long id;
    private PersonDto personId;
    private PartnerDto partnertId;
    private Date creation_date;
    private double totalAmount;
    private boolean status;

    
}
