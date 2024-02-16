package ServerClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static int port = 6600;
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Simple Socket Server");
        System.out.println("\t\t=================\n\n");

        ServerSocket serverSocket = new ServerSocket(port);

        try{
            while (true){
                Socket socket =  serverSocket.accept();
                System.out.println("Client is Connected...\n\n");

                try{
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println("Welcome to the Socket Programming"); //Send this message to the client
                }finally {//ones it is closed
                    socket.close();
                }
            }
        }finally {
            serverSocket.close();
        }
    }
}
