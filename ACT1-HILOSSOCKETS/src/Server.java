import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket listener = new ServerSocket(9999);
		
		System.out.println("Servidor Iniciado");
		
		try{
		while(true){
			
			Socket socket = listener.accept();
			
			//leer el número del cliente
			BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			int clientNumber = 0; 
			
			String inputString = input.readLine();
			
			//Comprobamos que efectivamente es un numero
			if(isNumeric(inputString)){
				clientNumber = Integer.parseInt(inputString);
			}
			
			//Información del Chatbot por departamentos
			String infoDepartamentos = new String();
			
			infoDepartamentos="";
			
			//creamos el stream de salida
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			if(!isNumeric(inputString)){
				out.println(inputString + "NO es un número.\n" + "\n");
			}else if(clientNumber <1 || clientNumber > 5 ){
				out.println("El número de departamento " + clientNumber + " no es válido.\n" + "\n");
			}
			else if(clientNumber >1 || clientNumber < 5){

				
				switch(clientNumber){
				case 1 : 
					infoDepartamentos = ("Se ha puesto en contacto con el departamento de Administración, nuestro horario es de 8:00 a 13:00 Puede dejarnos su consulta en la el siguiente teléfono 988212121.");
					break;
				case 2 :
					infoDepartamentos = ("Se ha puesto en contacto con el departamento Comercial, nuestro horario es de 10:00 a 18:00\n ");
					break;
				case 3 :
					infoDepartamentos = ("Se ha puesto en contacto con el departamento de Compras, nuestro horario es de 9:00 a 14:00\n ");
					break;
				case 4 :
					infoDepartamentos = ("Se ha puesto en contacto con el departamento de Finanzas, nuestro horario es de 8:00 a 13:00\n ");
					break;
				case 5 :
					infoDepartamentos = ("Se ha puesto en contacto con el departamento de Soporte, nuestro horario es de 10:00 a 15:00\n ");
					break;
			}
				out.println(infoDepartamentos);	
				
			//cerramos el socket
			socket.close();
			}
		}
		}finally{
			//cerramos el listener
			listener.close();
			
		}
		

	}
	
	public static boolean isNumeric(String str){
		
		try{
			Integer.parseInt(str);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
		
	}

}
