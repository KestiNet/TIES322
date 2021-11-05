import java.io.*;
import java.net.*;

public class TestiSovellus {
    private static DatagramSocket soketti = null;

    public static void main(String[] args) throws Exception {
        soketti  = new DatagramSocket(6666);
        boolean listening = true;
        while(listening){
            try {
                byte[] rec = new byte[256];
                DatagramPacket paketti = new DatagramPacket(rec, rec.length);
                soketti.receive(paketti);
                String str = new String(paketti.getData(), paketti.getLength());
                System.out.println(str);
            }
            catch(Exception e){
                listening = false;
                System.out.println("catch");
                break;
            }
        }


    }
}

