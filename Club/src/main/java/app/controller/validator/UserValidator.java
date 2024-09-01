/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Sebastian
 */
public class UserValidator extends CommonsValidator {
    
    public void validUserName(String username) throws Exception {
		super.isValidString("el nombre de usuario ", username);
	}
	public void validPassword(String password) throws Exception {
		super.isValidString("la contraseña de usuario ", password);
	}
	public void validRole(String role) throws Exception {
		super.isValidString("el rol de usuario ", role);
	}
}
