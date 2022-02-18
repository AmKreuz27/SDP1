import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class servidor {
public static void main (String[] args){
ServerSocket sc;

Socket so;
DataOutputStream salida;
DataInputStream entrada;
String mensajeRecibido;
Scanner teclado = new Scanner(System.in);
final int PUERTO = 5000;

try{
sc = new ServerSocket(PUERTO);
System.out.println("Servidor iniciado");

while(true){
so = sc.accept();
System.out.println("Se conecto uno...");
entrada = new DataInputStream(so.getInputStream());
salida = new DataOutputStream(so.getOutputStream());
String msn = "";
int contador=0;
while(!msn.equals("x")){

mensajeRecibido = entrada.readUTF();//Leemos respuesta
System.out.println(mensajeRecibido);
System.out.println("Escriba un msn para enviar");
msn = teclado.nextLine();
contador=msn.length();
salida.writeUTF(contador+""+msn);//enviamos mensaje

}
sc.close();

}

}catch(IOException ex){
Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);

}
}
}
