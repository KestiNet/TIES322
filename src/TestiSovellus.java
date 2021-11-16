import java.io.*;
import java.net.*;

public class TestiSovellus {
    private static DatagramSocket soketti = null;

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
                System.out.println("catched");
                break;
            }
        }


    }
}

