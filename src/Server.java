import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private ServerSocket ss; 
	private Socket s;
	private ObjectOutputStream oos;
	
	public Server(){
		try{
			ss = new ServerSocket(9999);
			s = ss.accept();
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject("Hola cliente feo");
			
			oos.close();
			s.close();
			ss.close();
			
		}catch(Exception e){
			
		}		
	 }
}
