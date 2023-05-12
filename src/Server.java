import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        System.out.println("A new client has been added");

        //asking the user for input
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

        //taking the input from socket
        BufferedReader socketInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        String messageSend, messageReceived;
        while(true) {
            messageSend = userInputReader.readLine();
            printWriter.println(messageSend);
            printWriter.flush();
            messageReceived = socketInputReader.readLine();
            System.out.println("Message from client: " + messageReceived);
        }
    }
}