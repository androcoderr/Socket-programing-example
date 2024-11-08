import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 9806;
        try {
            System.out.println("Waiting for client...");
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int number = Integer.parseInt(in.readLine());
            long factorialNumber = factorial(number);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(factorialNumber);
            System.out.println("Server says: " + factorialNumber);
            socket.close();
            serverSocket.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
