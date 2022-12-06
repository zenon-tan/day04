import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        int PORT = 12345;
    

        try {

            Socket cs = new Socket("localhost", PORT);
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            // dos.writeUTF("Hello World first");
            // dos.writeUTF("Hello World second");
            // dos.flush();
            // System.out.println("Message sent to server");
            
            // To send a continuous stream of messages from the console
            Scanner inputSc = new Scanner(System.in);
            String line;
            while((line = inputSc.nextLine()) != null) {
                if(line.equalsIgnoreCase("close")) {
                    dos.writeUTF("close");
                    dos.flush();
                    System.out.println("Exit from shell");
                    break;
                }

                dos.writeUTF(line);
                dos.flush(); //flush to send the data
                System.out.println("Message sent to client: " + line);
            }

            cs.close(); // Close the socket
            inputSc.close();


        } catch (UnknownHostException e) {
            System.out.println("Unable to reach the host");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
            
    } 
    
}
