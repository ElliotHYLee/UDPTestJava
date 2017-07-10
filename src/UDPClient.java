import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
	    InetAddress IPAddress = InetAddress.getByName("localhost");
	    byte[] sendData = new byte[1024];
	    byte[] receiveData = new byte[1024];
	    String sentence = "Hello, I'm a client";
	    sendData = sentence.getBytes();
	    System.out.println("UDP Client: starting");
	    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
	    clientSocket.send(sendPacket);
	    System.out.println("UDP Client: datagram sent");
	    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	    clientSocket.receive(receivePacket);
	    String modifiedSentence = new String(receivePacket.getData());
	    System.out.println("FROM SERVER:" + modifiedSentence);
	    clientSocket.close();
	}

}
