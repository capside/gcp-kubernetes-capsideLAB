package es.sephire.demos.kubernetes.backend;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.before;

public final class CorsFilter {
	private static final Map<String,String> corsHeaders = new HashMap<>();

	static {
		corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		corsHeaders.put("Access-Control-Allow-Origin", "*");
		corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
		corsHeaders.put("Access-Control-Allow-Credentials", "true");	
	}

	public static void apply(){
		before((request,response)-> {
			corsHeaders.forEach((name,value)->{
				response.header(name,value);
			});
		});
	}
}
