import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket serverSocket = new DatagramSocket(14550);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Server started");
        while(true){
          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
          serverSocket.receive(receivePacket);
          String sentence = new String( receivePacket.getData());
          System.out.println("RECEIVED: " + sentence);
          InetAddress IPAddress = receivePacket.getAddress();
          int port = receivePacket.getPort();
          //System.out.println(port);
          String capitalizedSentence = sentence.toUpperCase();
          sendData = capitalizedSentence.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
          serverSocket.send(sendPacket);
       }
	}

}
