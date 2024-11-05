/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sebastian
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateGuestRequest {
    private String name;
    private String document;
    private String cellphone;
    private String userName;
    private String password;
    private String partnerId;

}
