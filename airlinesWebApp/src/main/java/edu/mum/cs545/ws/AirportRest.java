package edu.mum.cs545.ws;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportRest {
	
	@Inject
	AirportService airportService;
	
	@GET
	@Path("/airports")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> getAirports() {
		return airportService.findAll();
	}
}
