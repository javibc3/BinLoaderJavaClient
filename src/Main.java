import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la IP destino:");
        String ip = sc.next();
        System.out.println("Introduzca el puerto destino");
        String port = sc.next();
        System.out.println("Introduzca el archivo a mandar");
        String filePath = sc.next();
        try {
            BinLoaderConnection.sendFile(ip,port,filePath);
        }catch (UnknownHostException host){
            System.err.println("Se ha introducido incorrectamente la IP o el puerto de la PS4");
        }catch (FileNotFoundException f){
            System.err.println("No se ha introducido correctamente la ruta del archivo");
        }
        catch (IOException e) {
            System.err.println("Se ha producido un error enviando el archivo");
        }
    }
}
