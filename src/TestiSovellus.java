import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestiSovellus {


    // private static DatagramSocket soketti = null;
   // private static DatagramSocket soketti = null;
   // private static DatagramSocket datasoc = null;

    public static void main(String[] args) throws IOException {
     //   soketti = new VirtualSocket(6666);
       DatagramSocket datasoc = new DatagramSocket(59489);

      /**  boolean listening = true;
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
**/

            String strn = "Moikka";
            byte[] bitti = strn.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dpac = new DatagramPacket(bitti, bitti.length, 59489);
            datasoc.send(dpac);
            datasoc.close();
            datasoc.disconnect();
        }
}
