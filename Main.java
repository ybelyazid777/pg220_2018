package prjtjavaaa;


import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.parser.ParseException;




public class Main {
	
	 public static void main(String[] args) throws Exception{

		 	
			
		    String USER_AGENT = "Mozilla/5.0";
		    String url = "https://www.metaweather.com/api/location/search/?query="+args[0];

		    URL obj = new URL(url);
		    HttpURLConnection hcon = (HttpURLConnection) obj.openConnection();

		    
		    hcon.setRequestMethod("GET");

		    
		    hcon.setRequestProperty("User-Agent", USER_AGENT);

		    
		    

		    BufferedReader in = new BufferedReader(
		            new InputStreamReader(hcon.getInputStream()));
		    String inputLine;
		    StringBuffer rps= new StringBuffer();

		    while ((inputLine = in.readLine()) != null) {
		      rps.append(inputLine);
		    }
		    in.close();
		    
		    
		    
		    
		    int n_jours=0;
		    int h_y=0;
		    int w_y=0;
		    
		    for (int i=1;i<args.length;i++){
		    	if(args[i].equals("-j")){
		    		
		    		n_jours= Integer.parseInt(args[i+1]);
		    		if (n_jours>5){
		    			n_jours=5;
		    		 System.out.println("Le nombre de jour pris vaut 5 car le nombre de jour entré est supérieur a 5");
		    		}
		    	}
		    	else if(args[i].equals("-w")){
		    		w_y=1;
		    		}
		    		else if(args[i].equals("-h")){
		    		h_y=1;
		    		}
		    	
		    }
		    	
		    
		    
		    
		    try{
		       
		       
					
		      
		      // JSONObject obj2 = (JSONObject)tab.get(0);
		       System.out.print("+-------------+");
		       for (int i =0;i<n_jours;i++){
		    	   System.out.print("--------+");
		       }
		       System.out.println("");
		       System.out.print("|             |");
		       for (int i =0;i<n_jours;i++){
		    	   System.out.print("  J+"+i+"   |");
		       }
		       System.out.println("");
		    
		       
		      
		       
		       
		       int flag=0;
		       for (int k=1;k<args.length;k++){
					if(args[k].equals("-m") && args[k+1].equals("[F]"))
						
						flag=1;
		       }
		       
		       MetaWeather meta = new MetaWeather(n_jours);
		       meta.update(args[0]);
		       
		       meta.description("| MetaWeather |", h_y, w_y,flag);
		      
		       
		       
		       Prev prev = new Prev(n_jours);
		       prev.update(args[0]);
		       
		       
						
				
		       prev.description("| P-Meteo     |", h_y, w_y,flag);
		     
		       
		       
		       
		       
		 
		       
		       
		       
		    }catch(ParseException sere){
				
		       System.out.println("position: " + sere.getPosition());
		       System.out.println(sere);
		    }

		}

}
