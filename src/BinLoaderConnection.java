import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class BinLoaderConnection{


    public static void sendFile(String ip, String port,String filePath) throws IOException,NumberFormatException,NullPointerException {
        if(ip.equals("")|| port.equals("") || filePath.equals("")) throw new NullPointerException();
        Socket connection = new Socket(ip,Integer.parseInt(port));
        FileInputStream file = new FileInputStream(filePath);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        byte[] buffer = new byte[4 * 1024];
        while (file.read(buffer) > 0){
                out.write(buffer);
        }
        file.close();
        out.close();
        connection.close();
    }
}
