package utb.fai;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    public static void main(String[] args) {
        //////////////////////////////////////////////////////////////////////////////////
        if (args.length < 2) {
            System.err.println("Pouzijte mene argumentu(2). <IP>,<port>");
            System.exit(1);
        }
        String serverIP = args[0]; // args[0] - IP adresa klienta, se kterým bude naše aplikace komunikovat
                                   // (String)

        int port; // args[1] - Číslo portu, na kterém bude aplikace komunikovat. Standardně 23 pro
                  // telnet. (int)
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Port musi byt cislo.");
            return;
        }
    }
        

    ///////////////////////////////////////////////////////////////////////////
    private static void runServer(int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server bezi na portu: "+ serverSocket.getLocalPort());
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Pripojil se novy klient: " + clientSocket.getInetAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}