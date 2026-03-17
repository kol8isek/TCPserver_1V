import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("TCP server spuštěn");
        ServerSocket server = new ServerSocket(5555);
        while (true){
            System.out.println("Čekám na připojení klienta");
            Socket socketKlienta = server.accept();
            String clientUP = socketKlienta.getInetAddress().getHostAddress();
            PrintWriter dataPosilanaKlientovi = new PrintWriter(socketKlienta.getOutputStream(), true);
            dataPosilanaKlientovi.println("Připojil ses k TCP serveru Petra Černého");
            Scanner dataKlienta = new Scanner(socketKlienta.getInputStream());
            while(dataKlienta.hasNextLine()){
                System.out.println(dataKlienta.nextLine());


            }
            System.out.println("Klient: " + clientUP + " ukončil spojení");
        }
    }
}