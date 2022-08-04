
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int port = 80;

        System.out.println("================\n" + "THE INTERNETS!\n" + "================");

        System.out.print("Where to? ");
        String address = input.nextLine();

        // establish the connection
        Socket socket = new Socket(address, port);

        System.out.println("==========\n" + "RESPONSE\n" + "==========");
        // send message to server
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        writer.println("Host: " + address);
        writer.println();
        writer.flush();

        Scanner reader = new Scanner(socket.getInputStream());

        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
    }
}
