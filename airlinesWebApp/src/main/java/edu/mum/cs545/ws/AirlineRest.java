package edu.mum.cs545.ws;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;

@Named
@Path("airline")
public class AirlineRest {
	
	@Inject
	private AirlineService airlineService;
	@Inject
	private AirplaneService airplaneService;
	
	@GET
	public String airlines(@DefaultValue("") @QueryParam("name") String name){
		String result="";
		if(name == ""){
			List<Airline> allAirlines = airlineService.findAll();
			for (Airline airline : allAirlines) {
				result += airline.getName() + "\n ";
			}
		}
		else{
			result = airlineService.findByName(name).getName();
		}
		return result;
	}
	
	@GET
	@Path("/airlines")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}
	
	@Path("create")
	@GET
	public boolean createAirline(@QueryParam("name") String name){
		
		Airline airport = new Airline(name);
		airlineService.create(airport);
		
		return true;
	}
	
	@Path("delete")
	@GET
	public boolean deleteAirline(@QueryParam("id") String id){
		
		Airline airport = new Airline();
		airport.setId(Long.parseLong(id));
		airlineService.delete(airport);
		
		return true;
	}
	
	@Path("update")
	@GET
	public boolean updateAirline(
			@QueryParam("old") String old,
			@QueryParam("new") String newName){
		
		Airline airport = airlineService.findByName(old);
		airport.setName(newName);
		airlineService.update(airport);
		
		return true;
	}
}
