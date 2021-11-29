import java.io.*;
import java.net.*;
import java.util.Random;

public class VirtualSocket extends DatagramSocket {
    private static double p_drop = 0.5;
    private static  double hidasta = 100000;

    public VirtualSocket() throws SocketException {


    }

    public VirtualSocket(int portti) throws SocketException {
        super(portti);

    }

    public void send(DatagramPacket paketti) throws IOException {
        while (true){
            Random hidastus = new Random();
            try {
                Thread.sleep((int) (hidastus.nextDouble() * 2 * hidasta));
                super.send(paketti);
                System.out.println("Paketti lähetetty");
                super.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }


    public void receive(DatagramPacket packet) throws IOException {
        while (true) {
            Random randGen = new Random();
            super.receive(packet);
            if (randGen.nextDouble() <= p_drop) {
                System.out.println("Dropped packet");
            } else {
                return;
            }
        }
    }
}