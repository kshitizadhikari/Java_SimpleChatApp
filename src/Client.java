import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",12345);

        //get message from server
        BufferedReader serverInputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //take input from user
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter printWriter = new PrintWriter((socket.getOutputStream()));

        String messageSend, messageReceived;
        while(true) {
            messageReceived = serverInputReader.readLine();
            System.out.println("Message from Server: " + messageReceived);
            messageSend = userInputReader.readLine();
            printWriter.println(messageSend);
            printWriter.flush();
           }
    }
}