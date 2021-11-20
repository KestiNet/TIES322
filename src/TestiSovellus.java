import java.io.*;
import java.net.*;
import java.net.Socket.*;

public class TestiSovellus {
    private static DatagramSocket soketti = null;
    private static DatagramSocket ulkoSoketti = null;

    public static void main(String[] args) throws Exception {
        soketti  = new VirtualSocket(6666);
        boolean listening = true;
        while(listening){
            try {
                byte[] rec = new byte[256];
                DatagramPacket paketti = new DatagramPacket(rec, rec.length);
                soketti.receive(paketti);
               // String str =  // remove CRC8
                System.out.println(new String(rec, 0, paketti.getLength()-1));
                System.out.println(rec[paketti.getLength()-1]);
            }
            catch(Exception e){
                listening = false;
                System.out.println("catcheed");
                break;
            }
        }
        Socket socket = new Socket("localhost", 54331);
        System.out.println("Connected!");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create a data output stream from the output stream so we can send data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        System.out.println("Sending string to the ServerSocket");

        // write the message we want to send
        dataOutputStream.writeUTF("Hello from the other side!");
        dataOutputStream.flush(); // send the message
        dataOutputStream.close(); // close the output stream when we're done.

        System.out.println("Closing socket and terminating program.");
        socket.close();


    }
}

