package prjtjavaaa;

import java.io.BufferedReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;

public class DataQuery {

	String data;
	
	public DataQuery(String url) throws Exception{
		String USER_AGENT = "Mozilla/5.0";
	    
	    URL obj = new URL(url);
	    HttpURLConnection hcon = (HttpURLConnection) obj.openConnection();

	    
	    hcon.setRequestMethod("GET");

	
	    hcon.setRequestProperty("User-Agent", USER_AGENT);

	 
	    

	    BufferedReader in = new BufferedReader(
	            new InputStreamReader(hcon.getInputStream()));
	    String inputLine;
	    StringBuffer rps = new StringBuffer();

	    while ((inputLine = in.readLine()) != null) {
	      rps.append(inputLine);
	    }
	    in.close();
	    
	   this.data=rps.toString();
	    
	}
	public String getData(){
		return this.data;
	}
}
