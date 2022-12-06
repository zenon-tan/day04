import java.net.Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileFromClient {

    public static void main(String[] args) {

        int PORT = 12345;

        try {

            // Typical way to set up a socket and send data
            Socket sc = new Socket("localhost", PORT);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(sc.getOutputStream()));
            
            // Read a file
            FileReader fr = new FileReader("src/input.txt");
            BufferedReader bfc = new BufferedReader(fr);
            String line;

            // While the line read is not null
            while(null != (line = bfc.readLine())) {
                dos.writeUTF(line);
                dos.flush();
            }

            // Once it has reached the end, send out an EOF message to end the reading
            // On the server side
            dos.writeUTF("EOF");
            // Sends a UTF to stop reading
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
