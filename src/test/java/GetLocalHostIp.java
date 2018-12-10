import java.net.InetAddress;

//获取本机IP地址及主机名
public class GetLocalHostIp {
    public static void main(String[] args)
        throws Exception{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: "+addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local Host Name: "+ hostname);
    }
}
