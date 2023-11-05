package ServerPackage;
import java.io.*;
import java.net.*;



public class Server extends Thread{
	int ord;
	public static void main(String[] args) {
		new Server().start();
		
	}
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Démarrage du Server");
			while(true) {
				Socket s = ss.accept();
				new ClientProcess(s, ++ord).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class ClientProcess extends Thread {
		Socket socket;
		private int numClient;
		public ClientProcess(Socket socket,int numClient) {
			super();
			this.socket = socket;
			this.numClient = numClient; 
		}
		public void run() {
			try {
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				pw.println("Client numéro "+numClient+" Votre address IP :"+socket.getRemoteSocketAddress());
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
