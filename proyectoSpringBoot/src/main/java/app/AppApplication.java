package app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppApplication  {
        
        
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
        
}


/* Error al tratar de ejecutar, no conceta con myphpadmin, esto imposibilita terminar y probar las demás funciones, 
Error:

11:01:37 p. m.  [main] 	Executing "c:\xampp\"
11:03:02 p. m.  [main] 	Executing "c:\xampp\"
11:04:39 p. m.  [mysql] 	Attempting to start MySQL app...
11:04:40 p. m.  [mysql] 	Status change detected: running
11:04:43 p. m.  [mysql] 	Status change detected: stopped
11:04:43 p. m.  [mysql] 	Error: MySQL shutdown unexpectedly.
11:04:43 p. m.  [mysql] 	This may be due to a blocked port, missing dependencies, 
11:04:43 p. m.  [mysql] 	improper privileges, a crash, or a shutdown by another method.
11:04:43 p. m.  [mysql] 	Press the Logs button to view error logs and check
11:04:43 p. m.  [mysql] 	the Windows Event Viewer for more clues
11:04:43 p. m.  [mysql] 	If you need more help, copy and post this
11:04:43 p. m.  [mysql] 	entire log window on the forums
*/