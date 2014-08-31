import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;


public class Server implements Runnable {
	private ServerSocket serverSocket; 
	private Socket socket;
	private ObjectOutputStream oOut;
	private ObjectInputStream oIn;
	private JTextArea areachat; 
	public Server(JTextArea areachat){		
		this.areachat = areachat;
	}

	@Override
	public void run() {
		try{
			serverSocket = new ServerSocket(9999);
			socket = serverSocket.accept();
			oOut = new ObjectOutputStream(socket.getOutputStream());
			oIn  = new ObjectInputStream(socket.getInputStream());			
			areachat.append("Conexión exitosa");
		}catch(Exception e){
			
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
	public void closeServer(){
		try{
			oIn.close();
			oOut.close();
			socket.close();
			serverSocket.close();
		}catch(Exception e){ }
	}
}
