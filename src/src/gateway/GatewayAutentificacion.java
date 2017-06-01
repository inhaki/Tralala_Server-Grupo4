package gateway;

import remoteFaçade.RemoteFaçade;
import socketServer.SocketServer;

//utiliza Singleton
public class GatewayAutentificacion implements IGatewayLogin{

	
	private static GatewayAutentificacion instance;
	private boolean state;
	
	public static GatewayAutentificacion getInstance() {
		if (instance == null) {
			try {
				instance = new GatewayAutentificacion();
			} catch (Exception ex) {
				System.err.println("# Error creating GatewayAutentificacion: " + ex);
			}
		}
		
		return instance;
	}
	
	@Override
	public boolean login(String aEmail, String aPassword) {
		// TODO Auto-generated method stub
		SocketServer ss = new SocketServer();
		boolean state=ss.login(aEmail, aPassword);
		//boolean state=ss.login("inhaki@gmail.com", "1234");
		System.out.println("Rseultado FINAL GATEWAY: " +state);
		return state;
	}
	
/*public static void main (String[]args)
	
	{
		
	getInstance().login("inhaki@gmail.com", "1234");

	}
*/
}
