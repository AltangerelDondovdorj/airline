package edu.mum.cs545.ws;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
import com.google.gson.*;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		//airlineService = new AirlineService();
		//Gson gson = new Gson();
		//gson.toJson(airlineService.findByName(name));
		return "Hello " + name + "! ";// + gson.toJson(airlineService.findByName("oneworld"));
	}

	@Path("airline")
	@GET
	public String getAirlineTest( @QueryParam("airplane") String name) {
		String result = "Nil!";
		Airline airline = airlineService.findByName("oneworld");
		if (airline != null) {
			result = "This is an airline: " + airline.getName();
		}
		return result;//(new Gson().toJson(airlineService.findByName("oneworld")));
	}

}
