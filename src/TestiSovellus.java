import java.io.*;
import java.net.*;

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
        ulkoSoketti = new VirtualSocket(54331);
        System.out.println("Connection Established");
        DatagramPacket ulkoPaketti = new DatagramPacket();
        OutputStream palvelimelle = ulkoSoketti.getOutputStream();


    }
}

