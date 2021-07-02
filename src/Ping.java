import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Date;
 
public class Ping {
	
	public long time = -1;
	
	public Ping()
	{
		
	}
	
	public long pingServer(String hostAddress)
	{
		try {
	         //dynamodb.us-east-1.amazonaws.com
	         int port = 80;
	         long timeToRespond = 0;
	 
	         InetAddress inetAddress = InetAddress.getByName(hostAddress);
	         //System.out.println(inetAddress.toString());
	         InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, port);
	 
	         SocketChannel sc = SocketChannel.open();
	         sc.configureBlocking(true);
	 
	         Date start = new Date();
	         if (sc.connect(socketAddress)) {
	            Date stop = new Date();
	            timeToRespond = (stop.getTime() - start.getTime());
	         }
	 
	         //System.out.println("Response time: " + timeToRespond + " ms");
	         return timeToRespond;
	      } catch (IOException ex) {
	         //System.out.println(ex.getMessage());
	         return -1;
	      }
		
	}
	
	public String ping(String hostAddress)
	{
		long time = pingServer(hostAddress);
		this.time = time;
		if(time < 0)
		{
			return "Error while connecting: Please check your connection.";
		}else
		{
			String str = "Server: " + getLocation(hostAddress) + ", Response time: " + time + " ms";
			
			return str;
		}
		
	}
	
	public String getLocation(String hostAddress)
	{
		if(hostAddress.equals(Servers.NAE1))
		{
			return "Virginia";
		}else if(hostAddress.equals(Servers.NAE2))
		{
			return "Ohio";
		}else if(hostAddress.equals(Servers.NAE3))
		{
			return "Canada";
		}else if(hostAddress.equals(Servers.NAW1))
		{
			return "California";
		}else if(hostAddress.equals(Servers.NAW2))
		{
			return "Oregon";
		}else if(hostAddress.equals(Servers.EU1))
		{
			return "Ireland";
		}else if(hostAddress.equals(Servers.EU2))
		{
			return "London";
		}else if(hostAddress.equals(Servers.EU3))
		{
			return "Paris";
		}else if(hostAddress.equals(Servers.EU4))
		{
			return "Frankfurt";
		}else if(hostAddress.equals(Servers.ME1))
		{
			return "Bahrain";
		}else if(hostAddress.equals(Servers.BR1))
		{
			return "Brazil";
		}else if(hostAddress.equals(Servers.OCE1))
		{
			return "Sydney";
		}else if(hostAddress.equals(Servers.ASIA1))
		{
			return "Seoul";
		}else if(hostAddress.equals(Servers.ASIA2))
		{
			return "Osaka";
		}else if(hostAddress.equals(Servers.ASIA3))
		{
			return "Tokyo";
		}else if(hostAddress.equals(Servers.ASIA4))
		{
			return "Singapore";
		}else
		{
			return "Undefined";
		}
		
		
	}
   
	public long getLastPing()
	{
		return this.time;
	}
}