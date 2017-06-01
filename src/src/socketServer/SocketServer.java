package socketServer;

import java.net.*;
import java.io.*;

public class SocketServer {


Socket sc;

int puerto =9000;

String ip = "127.0.0.1";

BufferedReader entradaResultado;
DataOutputStream salida1;

public boolean login(String email, String contraseña) 

{

	try
	
	{
	
		sc = new Socket(ip, puerto );
		
		//creamos el flujo de datos por el que se enviara un mensaje
		entradaResultado = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		
		salida1 = new DataOutputStream(sc.getOutputStream());
				
		//enviamos el mensaje
		
		salida1.writeBytes(email);
		
		salida1.writeBytes("\n");
		
		salida1.writeBytes(contraseña);
		
		salida1.writeBytes("\n");
		
		String login = entradaResultado.readLine();
		
		System.out.println(login);
		
		entradaResultado.close();
		salida1.close();

		
		sc.close();
		
		System.out.println("SocketServer dice:"+login);
		if(login.equals("OK")){
			return true;
		}
		/*if(login.equals(true)){
			return true;
		}*/
	
	}catch(Exception e )
	
	{
	
		System.out.println("Error: "+e.getMessage());
	
	}
	return false;
	
}

}
