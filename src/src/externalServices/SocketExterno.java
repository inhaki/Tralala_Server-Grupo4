package externalServices;

import java.net.*;
import java.io.*;


public class SocketExterno {

	int PUERTO=9000;
	
	ServerSocket sc;
	
	Socket so;
	
	BufferedReader entrada1;
	
	BufferedReader entrada2;
	
	DataOutputStream salida;
	
	String email;
	
	String contraseña;
	
	boolean resultado;
	
	//SERVIDOR
	
	public void initServer()
	
	{
	
		try
		
		{
		
		sc = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
		
		so=new Socket();
		
		System.out.println("Esperando una conexiÃ³n:S\n");
		
		so = sc.accept();
		
		LoginService ls = new LoginService ();
		
		System.out.println("Un cliente se ha conectado.S\n");
		
		entrada1 = new BufferedReader(new InputStreamReader(so.getInputStream()));
		
		salida = new DataOutputStream(so.getOutputStream());
		//salida.writeBytes("OK\n");
		
		email = entrada1.readLine();
		System.out.println("Entras o no? "+email);
		contraseña = entrada1.readLine();
		System.out.println("Entras o no? "+contraseña);
		resultado = ls.getUser(email, contraseña);
		System.out.println("resultado "+resultado);
		//salida.writeBoolean(resultado);
		//devuelve al Socket del Tralala OK o False
		if(resultado == true){
			salida.writeBytes("OK\n");
			System.out.println("Entras o no?");
			sc.close();
		}
		else{
			salida.writeBytes("FALSE\n");
			System.out.println("Entra aquí");
			sc.close();
		}
		
		/*System.out.println(email);
		
		System.out.println(contraseña);
		
		System.out.println(resultado);
		
		salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...C\n");
		
		salida.writeUTF("Gracias por conectarte, adios!C\n");
		
		System.out.println("Cerrando conexiÃ³n....\n");
		*/
		sc.close();//Aqui se cierra la conexiÃ³n con el cliente
		
		}catch(Exception e )
		
		{
		
		System.out.println("Error: "+e.getMessage());
		
		}
	
	}

}
