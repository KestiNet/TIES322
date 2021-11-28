import java.io.*;
import java.net.*;
import java.net.Socket.*;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws Exception {
        VirtualSocket socket = (VirtualSocket) new DatagramSocket();
        String viesti = "Toimiiko lähetys ";
        InetAddress iposoite = InetAddress.getByName("127.0.0.1");
        DatagramPacket paketti = new DatagramPacket(viesti.getBytes(),viesti.length(),iposoite,53641);
        socket.send(paketti);
        socket.close();
    }

}