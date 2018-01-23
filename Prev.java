package prjtjavaaa;



import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Prev extends Meteo{
	
	public Prev(int n){
		super(n);
	}
	
	
	
	
	void update(String city) throws Exception{
		DataQuery dataq1 = new DataQuery("https://www.prevision-meteo.ch/services/json/"+city);
		JSONParser prs1 = new JSONParser();

		try{
			Object prs1_o = prs1.parse(dataq1.getData());
			JSONObject array = (JSONObject)prs1_o;



			for(int i=0;i<super.n_jours;i++){
				JSONObject fcst_day = (JSONObject)array.get("fcst_day_"+i);
				JSONObject h_data = (JSONObject)fcst_day.get("hourly_data");
				long h=0;
				long w=0;
				
				long temp_min=(long)fcst_day.get("tmin");
				long temp_max=(long)fcst_day.get("tmax");
				long temp=(temp_max+temp_min)/2;
				
				for (int j=0;j<24;j++){
					JSONObject this_h = (JSONObject)h_data.get(j+"H00");
					
					h=h+(long)(this_h.get("RH2m"));
					w=w+(long)(this_h.get("WNDSPD10m"));
				}
				
				
				this.temp[i]=(double)temp;
				this.hum[i]=h/24;
				this.win[i]=(double)w/24;

		}

	}catch(ParseException sere){

		System.out.println("position: " + sere.getPosition());
		System.out.println(sere);
	}

	}
}