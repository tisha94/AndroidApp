package mobile.tiy.tishaapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Tisha868 on 5/11/16.
 */
public class AppClient {
    public String sendMessage(String sentMessage) {

        try {

            Socket clientSocket = new Socket("tisha",8005);
            String tisha = "172.168.4.6";  // <-- stores IP Address into persons name
            // "localhost" = connects to self
            // changed the clientSocket to connect to the server computer's IP address instead of "localhost".

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            // send the server a message
            out.println(sentMessage);


            String serverResponse;

            while (true) { // will print out evetyhing the sevrer is  sending back.
                // read what the server returns
                serverResponse = in.readLine(); // input 4rm server

                if (serverResponse.equals("end-transmission")){
                    break;
                }

                System.out.println(serverResponse);
            }

        }catch (Exception exception){

        }return null;
    }
}
