import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 9806;
        try {
            Socket socket = new Socket(hostName, port);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number to calculate the factorial.");
            int number = Integer.parseInt(userInput.readLine());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(number);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Server says factorial: " + in.readLine());
            socket.close(); // Soketi kapat
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
