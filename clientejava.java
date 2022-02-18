import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class cliente {
     public static void main(String[] args){
     final String HOST = "127.0.0.1";
     DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
    Scanner teclado = new Scanner(System.in);
     final int PUERTO = 5000;
     try{
         Socket sc = new Socket(HOST, PUERTO);
         
            salida = new DataOutputStream(sc.getOutputStream());
            entrada = new DataInputStream(sc.getInputStream());
            String msn = "";
            int contador=0;
            while(!msn.equals("x")){
                System.out.println("Escriba un msn para enviar");
                msn = teclado.nextLine();
                contador=msn.length();
                salida.writeUTF(contador+msn);//enviamos mensaje
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);
            }
            
            sc.close();
     }catch(IOException ex){
        Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);

        }
     }
}

