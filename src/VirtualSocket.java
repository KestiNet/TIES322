import java.io.*;
import java.net.*;
import java.util.Random;

public class VirtualSocket extends DatagramSocket {
    private static double p_drop = 0.5;

    public VirtualSocket() throws SocketException {
        super();
    }

    public VirtualSocket(int portti) throws SocketException {
        super(portti);

    }

    public void receive(DatagramPacket packet) throws IOException {
        while (true) {
            Random randGen = new Random();
            super.receive(packet);
            if (randGen.nextDouble() <= p_drop) {
                System.out.println("Dropper packet");
            } else {
                return;
            }
        }
    }
}