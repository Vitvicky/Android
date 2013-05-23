import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.sun.net.ssl.HttpsURLConnection;


public class distance {
public static void main(String[] args){
  URL myURL = null;
try {
myURL = new URL("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Vancouver+BC&mode=bicycling&language=zh-CN&sensor=false");
} catch (MalformedURLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} 
        URLConnection httpsConn = null;
try {
httpsConn = (URLConnection) myURL.openConnection();

        InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream()); 
        int respInt = insr.read(); 
        while (respInt != -1) { 
            System.out.print((char) respInt); 
            respInt = insr.read();
        }
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} 

}

} 