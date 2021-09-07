package hellowword_server;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
 
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


import myworker;

@SuppressWarnings("unused")
public class hellow {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		

		HttpServer server = null;
		try {
			server = HttpServer.create(new InetSocketAddress(4251), 0);
			System.out.println(":running on 4251");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("lsof -n -i4TCP:4521 and kill whats ever on that or change to running port");
			e.printStackTrace();
		}
		System.out.println("http://localhost:4251/myapp");
		System.out.println("http://localhost:4251/front");
		
		
		
		HttpContext context = server.createContext("/myapp");
		 
		context.setHandler((he) -> {
			String retrn_val = "NOT_VALID";
			String payload = he.getRequestURI().getQuery();
			// /myapp
			String workerreturn = "NONE";			
			
			
			if (payload!=null) {
				if (payload.length()>=2) {
					char varchack    = payload.charAt(0);
					
					char eqaul_check = payload.charAt(1);
					
				
					System.out.println(workerreturn);
					if ( (varchack == 'v')  & (eqaul_check=='=') ) {
						
						workerreturn = myworker.request(payload);
						System.out.println(workerreturn);
						
					
					
					}
				}
			}
			
			

			String outputjava ="FROM_JAVAWORKER "+workerreturn;
			
			he.sendResponseHeaders(200, outputjava.getBytes().length);
			final OutputStream output = he.getResponseBody();
			output.write(outputjava.getBytes());
			output.flush();
			
			
			he.close();
			});
			 
		HttpContext fornt = server.createContext("/front");
		 
		fornt.setHandler((he) -> {
			
			String fpayload = "\n"
					+ "\n"
					+ "<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "  <meta charset=\"UTF-8\">\n"
					+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "  <title>Java Frontend Link</title>\n"
					+ "  <!-- bootstrap link start -->\n"
					+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n"
					+ "    integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
					+ "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\n"
					+ "    integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
					+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"\n"
					+ "    integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n"
					+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"\n"
					+ "    integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n"
					+ "  <!-- bootstrap link end -->\n"
					+ "  <style>\n"
					+ "  .themainbutton{\n"
					+ "    min-width: 220px;\n"
					+ "\n"
					+ "  }\n"
					+ "  \n"
					+ "\n"
					+ "  </style>\n"
					+ "</head>\n"
					+ "\n"
					+ "</br>\n"
					+ "</br>\n"
					+ "<body style=\"background-color: #24222a;\">\n"
					+ "\n"
					+ "  <div class=\"container \">\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "    <div class=\"justify-content-center\">\n"
					+ "        <div id = \"place_to_stick_stuff\"><label for=\"uname\" class=\"text-white\">NO traid made </label></div>\n"
					+ "        </br>\n"
					+ "          <label for=\"uname\" class=\"text-white\">Money1</label>\n"
					+ "        </br>\n"
					+ "          <input type=\"text\" class=\"form-control\" id=\"money\" name=\"uname\" placeholder=\"User Name\" value=\"\">\n"
					+ "        </br>\n"
					+ "      </br>\n"
					+ "          <label for=\"password\" class=\"text-white\">Money2</label>\n"
					+ "          <input type=\"text\" class=\"form-control\" id=\"money2\" name=\"hashword\" placeholder=\"HashWord\" value=\"\">\n"
					+ "\n"
					+ "        </br>\n"
					+ "\n"
					+ "\n"
					+ "        <button type=\"submit\" class=\"btn btn-primary\" value=\"Submit\" onclick=\"letsgo()\">make_traid</button>\n"
					+ "\n"
					+ "    </div>\n"
					+ "  </div>\n"
					+ "\n"
					+ "\n"
					+ "<iframe width=\"760\" height=\"515\" src=\"http://alexhaussmann.com/adhaussmann/a_final/make_newpage.php?usertemplate_name=example_mygameJFUNGICYOOTDPWQGNSSGNLOBJTTKEH&var1=W&uname=&hashword=&setion=00bec2a7085dce8636c1e9dde9ec38e090983a940e8dc93ebbf704370eeef790&setion2=4f04dd1c15337a61143fe96794f74001b2371a674dcff6822d77fa3e73719745&rep=\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "    <script>\n"
					+ "\n"
					+ "\n"
					+ "    function convert_to_float(a) {\n"
					+ "          \n"
					+ "        var floatValue = +(a);\n"
					+ "          \n"
					+ "        return floatValue; \n"
					+ "    }\n"
					+ "        function post_responce(path,func,varible){\n"
					+ "        console.log(path);\n"
					+ "        fetch(path).then(\n"
					+ "            ( response) => {\n"
					+ "                return response.text();\n"
					+ "            })\n"
					+ "            .then((html) => {\n"
					+ "                func(  html.trim()  , varible )\n"
					+ "            });\n"
					+ "      }\n"
					+ "\n"
					+ "function test(A,B){\n"
					+ "  //alert(A);\n"
					+ "\n"
					+ "  output= A.split(\" \");\n"
					+ "\n"
					+ "  if (output[1]==\"success\") {\n"
					+ "\n"
					+ "  document.getElementById(\"place_to_stick_stuff\").innerHTML = \"<label for=\\\"uname\\\" class=\\\"text-white\\\">\"+\"amount of money left = \"+output[2]+\"</br>traidid = \"+output[3]+\"</label>\";\n"
					+ "  }\n"
					+ "  else{\n"
					+ "  document.getElementById(\"place_to_stick_stuff\").innerHTML = \"<label for=\\\"uname\\\" class=\\\"text-white\\\">\"+A+\"</label>\";\n"
					+ "  }\n"
					+ "\n"
					+ "}\n"
					+ "function letsgo(){\n"
					+ "  console.log(\"myapp?v=\"+document.getElementById(\"money\").value+\",\"+document.getElementById(\"money2\").value);\n"
					+ "    //test(\"FROM_JAVAWORKER success 802.5 dqfcprlwzwuqjawjmuqhpfpcodkqvnbtvfhicccdsiiocykzsanwmcodyonlipbs 0.69469,0.69469,2.97413,0.674565,1.77479,0.5,1.3125\",\"B\");\n"
					+ "\n"
					+ "    post_responce(\"myapp?v=\"+document.getElementById(\"money\").value+\",\"+document.getElementById(\"money2\").value ,test,\"hey\");\n"
					+ "\n"
					+ "    \n"
					+ "}\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "//alert(\"JS works\");  \n"
					+ "\n"
					+ "  </script>\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "  </body>\n"
					+ "\n"
					+ "";
			he.sendResponseHeaders(200, fpayload.getBytes().length);
			final OutputStream output = he.getResponseBody();
			output.write(fpayload.getBytes());
			output.flush();
			he.close();
			});
			 
		
		
		server.start();
	
		};
	
	

}
