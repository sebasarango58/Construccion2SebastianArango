/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller.validator;

/**
 *
 * @author Sebastian
 */
public class PersonValidator extends CommonsValidator{
   
    public PersonValidator() {
		super();
	}
	
	public void validName(String name) throws Exception{
		super.isValidString("el nombre de la persona ", name);
	}
	
	public long validDocument(String document) throws Exception{
		return super.isValidLong("la cedula de la persona ", document);
	}
	
	public long validCellphone(String cellphone) throws Exception{
		return super.isValidInteger("el celular de la persona ", cellphone);
	}
    
}
