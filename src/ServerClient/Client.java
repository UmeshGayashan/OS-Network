package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    static int port = 6600; //Otherwise client cannot connect with the server(Server Port also same)
    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Client\n");
        System.out.println("\t\t================\n\n");

        InetAddress ipAddress = InetAddress.getLocalHost(); //Because of only using this Computer

        Socket socket = new Socket(ipAddress,port); //Creating client socket

        System.out.println("Server is Connected....\n\n");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Get form Sever side
        String input = in.readLine();

        System.out.println("Server says:"+input);
        System.out.println("Closing Connection.......");
        socket.close();
        in.close();
        System.exit(0);
    }
}
