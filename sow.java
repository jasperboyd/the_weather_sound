import com.cycling74.max.*;
import java.io.IOException; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.net.URL; 
import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;

public class sow extends MaxObject
{

	private static final String[] INLET_ASSIST = new String[]{
		"inlet 1 help"
	};
	private static final String[] OUTLET_ASSIST = new String[]{
		"outlet 1 help"
	};
	
	public sow(Atom[] args)
	{
		declareIO(1, 15);
		
		setInletAssist(INLET_ASSIST);
		setOutletAssist(OUTLET_ASSIST);
		createInfoOutlet(false);
	}
    
	public void bang()
	{
		String json = ""; //to make the compiler happy
		try{
			 Gson gson = new Gson();
       		 String apiKey = "7a1408721556a5aa";
        	 String urlString = "http://api.wunderground.com/api/7a1408721556a5aa/conditions/q/CA/San_Francisco.json";       
       		BufferedReader reader = null;
        	try {
            	URL url = new URL(urlString);
           	 	reader = new BufferedReader(new InputStreamReader(url.openStream()));
           		 StringBuilder buffer = new StringBuilder();
            	int read;
            	char[] chars = new char[1024];
            	while ((read = reader.read(chars)) != -1) {
               		 buffer.append(chars, 0, read);
            	} 

            	json = buffer.toString(); 

       		 } finally {
            		if (reader != null) {
              		  reader.close();
             		}
             }

        	Map< String, Object > decoded =
           		gson.fromJson(
             		json,
             		new TypeToken< Map< String, Object>>() {}.getType());

        	Answer answer = gson.fromJson( json, Answer.class );
		
			outlet(0, answer.current_observation.temp_f); 
			outlet(1, answer.current_observation.feelslike_f);
			outlet(2, answer.current_observation.windchill_f);
			outlet(3, answer.current_observation.wind_degrees); 
			outlet(4, answer.current_observation.wind_mph); 
			outlet(5, answer.current_observation.wind_gust_mph); 
			outlet(6, answer.current_observation.visibility_mi);
			outlet(7, answer.current_observation.UV); 
			outlet(8, answer.current_observation.pressure_in); 
			outlet(9, answer.current_observation.pressure_trend); 
			outlet(10, answer.current_observation.dewpoint_f);
			outlet(11, answer.current_observation.relative_humidity);
			outlet(12, answer.current_observation.precip_1hr_in);	
			outlet(13, answer.current_observation.precip_today_in); 
			outlet(14, answer.current_observation.solarradiation); 
		} catch (Exception e) 
		{	
		}
	}

		// POJO classes for holding the JSON
    static class Response {
      String                version;
      URL                   termsofService;
      Map< String, String > features;
    }//response
   
    static class Observation {
      Map< String, String > image;
      Map< String, String > display_location;
      Map< String, String > observation_location; 
      Estimated             estimated;
      String station_id;
      String observation_time; 
      String observation_time_rfc822; 
      String observation_epoch; 
      String local_time_rfc822; 
      String local_tz_short; 
      String local_tz_long; 
      String local_tz_offset; 
      String weather; 
      String temperature_string; 
      int temp_f; 
      String temp_c; 
      String relative_humidity; 
      String wind_string; 
      String wind_dir; 
      int wind_degrees; 
      int wind_mph; 
      int  wind_gust_mph; 
      String wind_kph; 
      String wind_gust_kph; 
      String pressure_mb; 
      int pressure_in; 
      String pressure_trend; 
      String dewpoint_string; 
      int dewpoint_f; 
      String dewpoint_c; 
      String heat_index_string; 
      String heat_index_f; 
      String heat_index_c; 
      String windchill_string; 
      int windchill_f; 
      String windchill_c; 
      String feelslike_string; 
      String feelslike_f;
      String feelslike_c; 
      float visibility_mi; 
      String visibility_km; 
      String solarradiation; 
      String UV;
      String precip_1hr_string;
      float precip_1hr_in;
      String precip_1hr_metric; 
      String precip_today_string; 
      float precip_today_in; 
      String precip_today_metric; 
      String icon; 
      String icon_url; 
      String forcast_url;
      String history_url; 
      String ob_url; 
    }//Observation
   
   static class Estimated{
       //empty JSON
   }//Estimated

   static class Answer{
      Response    response;
      Observation current_observation;
   }//Answer
    
	public void inlet(int i)
	{
	}
    
	public void inlet(float f)
	{
	}
    
    
	public void list(Atom[] list)
	{
	}
    
}




