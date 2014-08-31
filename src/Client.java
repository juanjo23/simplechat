import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;


public class Client implements Runnable{
	private Socket socket;
	private ObjectOutputStream oOut;
	private ObjectInputStream oIn;
	private JTextArea areachat;
	
	
	Client(JTextArea areachat){
		this.areachat = areachat;		
	}
	
	@Override
	public void run() {
		try {
			socket = new Socket("127.0.0.1", 9999);
			oIn = new ObjectInputStream(socket.getInputStream());
			oOut = new ObjectOutputStream(socket.getOutputStream());
			areachat.append("Conexión exitosa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
		
	public void writeLine(String line){
		try{
			oOut.writeObject(line);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void readLine(){
		try{
			while(true){
				String line = oIn.readObject().toString();				
				areachat.append("Client: "+line);
				Thread.sleep(15);				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void close(){
		try{
			oIn.close();
			oOut.close();
			socket.close();
		}catch(Exception e){ }
	}
}
