package hellowword_server;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class controler {
	
	public String path = "";
	
	public String call( String urlval  ) throws IOException {
		URL url = new URL(path+urlval);
		//System.out.println(path+urlval);
		InputStream is = url.openStream();
		int ptr = 0;
		StringBuffer buffer = new StringBuffer();
		while ((ptr = is.read()) != -1) {
		    buffer.append((char)ptr);
		}
		String output = buffer.toString();
		output =output.trim();
		return output;		
	
	
	
	}

}


