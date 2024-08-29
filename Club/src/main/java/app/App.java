/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import app.controller.AdminController;

/**
 *
 * @author Sebastian
 */
public class App {
    
    public static void main(String[] args) throws Exception {
        AdminController controller = new AdminController();
        try {
        controller.createPartner();}
        catch(Exception e){
                System.out.println(e.getMessage());
                
        }
		
	}
}
    