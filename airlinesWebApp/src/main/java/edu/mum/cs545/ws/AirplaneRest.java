package edu.mum.cs545.ws;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
@Path("airplane")
public class AirplaneRest {
	
	@Inject
	private AirplaneService airplaneService;
	
	@GET
	@Path("/airplanes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airplane> getAirplanes() {
		return airplaneService.findAll();
	}
}
