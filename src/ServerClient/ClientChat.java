package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    static int port = 7777; //Otherwise client cannot connect with the server(Server Port also same)
    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Client\n");
        System.out.println("\t\t================\n\n");

        Scanner scannerinput = new Scanner(System.in);
        String input,output;

        InetAddress ipAddress = InetAddress.getLocalHost(); //Because of only using this Computer

        Socket socket = new Socket(ipAddress,port); //Creating client socket

        System.out.println("Server is Connected....\n\n");

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Get form Sever side


        try{
            while(true){
                input = in.readLine();
                System.out.println("Server says: "+ input);

                System.out.println("Client: ");
                output = scannerinput.nextLine();
                out.println(output);
            }

        }finally {//ones it is closed
            socket.close();
            in.close();
            out.close();
        }
    }
}
