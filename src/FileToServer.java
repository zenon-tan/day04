import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.transform.Source;

public class FileToServer {

    public static void main(String[] args) {

        int PORT = 12345;

        try {

            // Typical way to set up a server and input stream
            ServerSocket server = new ServerSocket(PORT);
            Socket sc = server.accept();
            DataInputStream dis = new DataInputStream(new BufferedInputStream(sc.getInputStream()));

            // To read from the file, we need a loop until it reads to the end
            // Read the first line
            String line = dis.readUTF();
            while(!line.equalsIgnoreCase("EOF") && line != null) {

                try {

                // EOF is end of file
                System.out.println("Got: " + line);

                // Read the next line
                line = dis.readUTF();
                    
                } catch (EOFException e) {
                    System.out.println( "---Reached end of file---");
                }


            }
            sc.close();


            
        } catch (IOException e) {
            e.printStackTrace();
        }

        

    


            
    } 


    
}
