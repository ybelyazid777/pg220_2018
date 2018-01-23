package prjtjavaaa;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MetaWeather extends Meteo{

	public MetaWeather(int n){
		super(n);
	}
	
	void update(String city) throws Exception{
		DataQuery x1 = new DataQuery("https://www.metaweather.com/api/location/search/?query="+city);
		JSONParser ser = new JSONParser();
		
	    try{
		       Object o = ser.parse(x1.getData());
		       JSONArray tab = (JSONArray)o;
				
		       JSONObject line = (JSONObject)tab.get(0);
		       String id = String.valueOf(line.get("woeid"));
		   	   
		       DataQuery x2 = new DataQuery("https://www.metaweather.com/api/location/"+id);
		   	  
		   	   Object o2 = ser.parse(x2.getData());
		   	   JSONArray tab2 = new JSONArray();
		   	   tab2.add(o2);
		   	   JSONObject obj2 = (JSONObject)tab2.get(0);
		   	   Object consolidated_weather = obj2.get("consolidated_weather");
		   	   for(int i=0;i<super.n_jours;i++)
		   	   {
		   		JSONArray ar = (JSONArray)consolidated_weather;
		   		JSONObject infos = (JSONObject)ar.get(i);
		   		
		   		this.hum[i]=(long)(infos.get("humidity"));
		   		this.temp[i]=(double)(infos.get("the_temp"));
		   		this.win[i]=(double)(infos.get("wind_speed"));
		   	   }
		       
		         


		    }catch(ParseException sere){
				
		       System.out.println("position: " + sere.getPosition());
		       System.out.println(sere);
		    }
		
		
		
	}
}