import java.io.*;
import java.net.*;
import java.net.Socket.*;
import java.nio.charset.StandardCharsets;

public class Client {


    private static DatagramSocket soketti = null;

    public static void main(String[] args) throws Exception {
        soketti = new VirtualSocket(54331);
        boolean listening = true;
        while (listening) {
            try {
                byte[] rec = new byte[256];
                String str = "Welcome java ";
                //What does this mean "Exception in thread "main" java.net.BindException: Address already in use: bind"
                //DatagramPacket paketti = new DatagramPacket(rec, rec.length);
                DatagramSocket ds = new DatagramSocket();
                // String str =  // remove CRC8
                //System.out.println(new String(rec, 0, paketti.getLength() - 1));
                //System.out.println(rec[paketti.getLength() - 1]);
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), 54331);
                soketti.send(dp);
                soketti.close();


            } catch (Exception e) {
                listening = false;
                System.out.println("catched");
                break;


                //DatagramSocket ulkoSoketti = null;

                // ulkoSoketti = new VirtualSocket(54331);

                //DatagramSocket ds = new DatagramSocket();
                //  String str = "Welcome java ";
                //InetAddress ip = InetAddress.getByName("127.0.0.1");

                //DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ulkoSoketti, 54331);
                //   ds.send(dp);
                // ds.close();

            }
        }
    }
}