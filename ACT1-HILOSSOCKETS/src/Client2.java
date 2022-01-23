import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Pedir la IP
		String serverAddress = System.console().readLine("Introduce la direccion Ip del ChatBot\n");
		
		while(true){
			//solicitar numero de 1 a 5
			String number = System.console().readLine(" \n"
					+ "Bien venido a la empresa UE \n"
					+ " \n"
					+ "Marque el numero correspondiente al departamento con quien quiere ponerse en contacto:\n"
					+ "1 = Administración\n"
					+ "2 = Comercial\n"
					+ "3 = Compras\n"
					+ "4 = Finanzas\n"
					+ "5 = Soporte\n"
					+ " \n");
			
			//Creamos el socket
			Socket socket = new Socket(serverAddress, 9999);
			
			//Enviamos número al servidor
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(number);
			
			//recibimos la respuesta del servidor
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String answer = input.readLine();
			
			//imprimir el mensaje
			System.out.println(answer);
			
			//cerrar el socket
			socket.close();
			
		}
}

}
