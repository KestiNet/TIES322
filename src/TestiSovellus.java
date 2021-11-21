import java.io.*;
import java.net.*;
import java.net.Socket.*;
import java.nio.charset.StandardCharsets;

public class TestiSovellus {
  //**  private static DatagramSocket soketti = null;
    //private static DatagramSocket ulkoSoketti = null;

    public static void main(String[] args) throws Exception {

    /**    ulkoSoketti = new VirtualSocket(54331);

        DatagramPacket dataOutputStream = new DatagramPacket();
        String str = "Moi";
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),ulkoSoketti);
        dataOutputStream.("Hello from the other side!");
        dataOutputStream.flush(); // send the message
        dataOutputStream.close(); // close the output stream when we're done.

        System.out.println("Closing socket and terminating program.");
        socket.close();
**/

            DatagramSocket ds = new DatagramSocket();
            String str = "Welcome java ";
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 54331);
            ds.send(dp);
            ds.close();
        }
    }



