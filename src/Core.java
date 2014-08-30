import java.util.Scanner;


public class Core {
	public Core(){
		System.out.println("1 Server... ");
		System.out.println("2 Client... ");
		Scanner s = new Scanner(System.in);
		if(s.nextInt() == 1){
			Server servidor = new Server();				
		}else{
			Client cliente = new Client();
		}		
	}
}
