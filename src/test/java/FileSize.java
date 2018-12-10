import java.net.URL;
import java.net.URLConnection;

public class FileSize {
    public static void main(String[] args) throws Exception{
        int size;
        URL url = new URL("http://qtwoss.qtbigdata.com/jph_1527837033212d9fe4c24b6834e50aaca80fd30efb858");
        URLConnection conn = url.openConnection();
        size = conn.getContentLength();
        if (size < 0)
            System.out.println("无法获取文件大小。");
        else
            System.out.println("文件大小为：" + +size + " bytes");
            conn.getInputStream().close();
        }
    }