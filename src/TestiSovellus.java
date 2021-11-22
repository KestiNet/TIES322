import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestiSovellus {

    private static DatagramSocket soketti = null;
    public static void main(String[] args) throws Exception {
        soketti  = new VirtualSocket(6666);
        boolean listening = true;
        while (listening) {
            try {
                byte[] rec = new byte[256];
                DatagramPacket paketti = new DatagramPacket(rec, rec.length);
                soketti.receive(paketti);
                // String str =  // remove CRC8
                System.out.println(new String(rec, 0, paketti.getLength() - 1));
                System.out.println(rec[paketti.getLength() - 1]);
            } catch (Exception e) {
                listening = false;
                System.out.println("catcheed");
                break;
            }
        }
    }
}

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
/**
            DatagramSocket ds = new DatagramSocket();
            String str = "Welcome java";
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
            ds.send(dp);
            ds.close();**/





