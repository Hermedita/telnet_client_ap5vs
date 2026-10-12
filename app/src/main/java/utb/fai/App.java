package utb.fai;

public class App {

    public static void main(String[] args) throws InterruptedException {
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
    
        new TelnetClient(serverIP, port).run();
    }
       
}