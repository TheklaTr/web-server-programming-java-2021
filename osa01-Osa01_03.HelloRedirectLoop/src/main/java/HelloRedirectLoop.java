
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        int numberOfReqs = 1;

        while (true) {
            // odotetaan pyyntöä
            Socket socket = server.accept();
            System.out.println("Request number" + numberOfReqs);

            // read the request
            Scanner input = new Scanner(socket.getInputStream());
            numberOfReqs++;

            if (input.nextLine().contains("/quit")) {
                break;
            }

            // write the answer
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            writer.println("HTTP/1.1 302 Found");
            writer.println("Location: http://localhost:8080");

            writer.flush();

            // release the resources
            input.close();
            writer.close();
            socket.close();
        }

    }
}
