import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TestiSovellus {


   // private static DatagramSocket soketti = null;
    private static DatagramSocket ulkoSoketti = null;

    public static void main(String[] args) throws SocketException {
        /**soketti = new VirtualSocket(6666);
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
        }**/
        boolean kokeile = true;
        while (kokeile) {
            try {
                ulkoSoketti = new VirtualSocket();
                String strn = "Testi";
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                DatagramPacket paketti = new DatagramPacket(strn.getBytes(), strn.length(),ip,54331);
                ulkoSoketti.send(paketti);
                ulkoSoketti.close();
            }catch (Exception e){
                kokeile = false;
                System.out.println("failed");
                break;
            }
        }

    }
        }
