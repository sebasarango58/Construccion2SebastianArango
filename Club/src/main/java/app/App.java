/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import app.config.MYSQLConnection;
import app.controller.ControllerInterface;
import app.controller.LoginController;

/**
 *
 * @author Sebastian
 */
public class App {
    
    public static void main(String[] args) throws Exception {
		ControllerInterface controller = new LoginController();
		try {
			controller.session();
			MYSQLConnection.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

    