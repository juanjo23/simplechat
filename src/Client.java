import java.io.ObjectInputStream;
import java.net.Socket;


public class Client{
	private Socket s;
	private ObjectInputStream ois;
	
	Client(){
		try{
			s = new Socket("localhost", 9999);
			ois = new ObjectInputStream(s.getInputStream());
			System.out.println(ois.readObject().toString());
			ois.close();
			s.close();
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}
}
