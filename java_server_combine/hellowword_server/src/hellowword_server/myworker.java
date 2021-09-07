package hellowword_server;

import java.io.IOException;



import controler;
public class myworker {
	static controler myurl = new controler();
	static controler stock = new controler();
	
	
	public static String getmainarg(String myvalue) {
		String output = "";
		String comparitor = "(???)";
		char holder[] = new char[comparitor.length()];
		for (int i = 0; i < comparitor.length(); i++) {
			holder[i]='a';
		}
		int counter =0;
		boolean haspassed = false; 
	    for(int i = 0; i<myvalue.length(); i++) {

	        char myval = myvalue.charAt(i);
			for (int m = 1; m < comparitor.length(); m++) {
				holder[m-1]=holder[m];
				
			}
			holder[comparitor.length()-1]= myval;
	        if (haspassed) {
	        	if (counter==comparitor.length()) {
	        		output=output+holder[0];
	        	}
	        	else {
	        		counter=counter+1;
	        	}
	        }
	        Boolean outtruth= true;
	        for (int m = 1; m < 5; m++) {
	        	outtruth=outtruth && holder[m]==comparitor.charAt(m-1);
	        	
	        }
	        if ( outtruth ) {
	        	if (haspassed==false) {
	        		haspassed=true;
	        	}
	        	else {
	        		return output;
	        	}
	        }
	      }
		
		return "NULL";
	}
	
	
	public static String request( String urlval  ) throws IOException {
			
		
		String traid_compleation;
		
		String Newtxt = urlval.substring(1);
		String last   = Newtxt.substring(1);

		myurl.path = "http://alexhaussmann.com/adhaussmann/a_final/";
		stock.path = "http://127.0.0.1:8000/doit?";
		
		
		if (urlval.length()<3) {
			return "";
		}

		
		
		
		System.out.println(last);
		String[] values  = last.split(",", 2);

		if (values.length==2) {
			float money_1_traid = 0;
			float money_2_traid = 0;
		    try{
		    	money_1_traid=Float.parseFloat(values[0]);		        
		    }catch(NumberFormatException e1){
		    	return "invalid";
		    }
		    if (money_1_traid<=0) {
		    	return "invalid less then zero";
		    }
		    try{
		    	money_2_traid=Float.parseFloat(values[1]);		        
		    }catch(NumberFormatException e1){
		    	return "invalid";
		    }
		    if (money_2_traid<0) {
		    	return "invalid";
		    }
		    String command1  ="user=myuser2&password=pass&request_type=money1&send_type=money2&request_amound="+values[1]+"&send_amount="+values[0]+"&action_type=maketraid";// Check conversion 
		    String traidid = "";
		    String[] traidarray = new String[2];
		    traidarray[0]="";
		    traidarray[1]="";
		    
		    
			try {
				traidid =  stock.call(command1);
				if (traidid.equals("nofunds")) {
					return "nofunds_in_acound";
				}
				System.out.println(traidid);
				traidarray = traidid.split(" ");
				//check for fail here
				
				
			} catch (IOException e1) {
				return "error updating";
			}
		    String updater = "";
			if (traidid.equals("")){
				return "triad error";
			}
			else {
			    String command2  ="user=myuser3&password=pass&traid_id="+traidarray[0]+"&action_type=fintraid";// Make trade
				try {
					traid_compleation =  stock.call(command2);	
					//checks for fail.
					
					if (traid_compleation.equals("nofunds")) {
						return "nofunds_in_traid_acount";
					}					
				} catch (IOException e1) {
					return "error_updating";
				}
			}
			try {
				updater= stock.call("user=&action_type=print_convertion");				
			} catch (IOException e1) {
				return "error_updating";
			}
			if (updater.equals("")) {
				return "fail";
			}
			updater =updater.replaceAll("</br>",",");
			String[] backarray = updater.split(",");
			String replace_value = "0";
			for (int i = 1; i < backarray.length; i++) {
				if(backarray[i].equals("money2_money1") ) {
				    try{
						replace_value=String.valueOf( Float.parseFloat(backarray[i+1]) );
				    			        
				    }catch(NumberFormatException e1){
				    	return "error_updating";
				    }
				}
			}
			String com2= "NONE";
			String com2out= "NONE";
			try {
				com2 =  myurl.call("get_post_dev.php?key=d79ab9711bee2a2463770f3fc6aa0f74bc522ea1988efd97ded0185e6f204683&type=all");					
			} catch (IOException e1) {
				return "error updating";
			}
			String[] arrOfStr = getmainarg( com2 ).split(",");
			float[] valus  = new float[ arrOfStr.length ];
			valus[0]=0;
			for (int i = 1; i < arrOfStr.length; i++) {
				valus[i]=0;
			    try{
			    	valus[i]=Float.parseFloat(arrOfStr[i]);		        
			    }catch(NumberFormatException e1){
			    	return "fail";
			    }   
			}
			String outsting = "";
			for (int i = 1; i < valus.length; i++) {	
				outsting+=String.valueOf( valus[i] )+",";	
			}
			outsting+=replace_value;
			try {
				myurl.call("change_post.php?uname=Myjavaworker&hashword=Myjavapassword&change_text="+outsting+"&post=d79ab9711bee2a2463770f3fc6aa0f74bc522ea1988efd97ded0185e6f204683");
			} catch (IOException e1) {
				return "error_updating";
			}
			return "success "+traidarray[1]+" "+traidarray[0]+" "+outsting;
			
		}
		else {
			return "invalidentery";
			
		}
		
	}
		
	
	
}
