package ClientPackage;
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
			
			//Connexion
			System.out.println("Je suis un client pas encore connecté...");
			InetAddress ia = InetAddress.getByName("192.168.0.3");
			InetSocketAddress isa = new InetSocketAddress(ia,1234);
			Socket socket = new Socket();
			socket.connect(isa);
			System.out.println("Je suis un client connecté");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			System.out.println(s);
			
			//Fermeture du Connexion
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
