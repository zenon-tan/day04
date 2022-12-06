import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("SOCKET SERVER: ");

        int PORT = 12345;

        // Create Server Socket

        try {

            ServerSocket server = new ServerSocket(PORT);

            // Get the socket object
            Socket socket = server.accept();
            // New connection froma client (Accepting it from the client; will be blocked until cdata arrives)

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            // String msg = dis.readUTF(); // Read message from client, it will be available here
            // String msg2 = dis.readUTF();
            // System.out.println("Message from client: " + msg );
            // System.out.println("Message from client: " + msg2 );
            // socket.close();

            String fromClient = dis.readUTF();
            while(!fromClient.equalsIgnoreCase("exit") && fromClient != null) {

                // Process the message
                System.out.println("Message from client: " + fromClient);
                // Keep reading
                fromClient = dis.readUTF();

            }

            System.out.println("Closing socket...");
            socket.close();
        } catch (IOException e) {
            System.out.println("IO Error " + e.getMessage());
        }



    
    }
}