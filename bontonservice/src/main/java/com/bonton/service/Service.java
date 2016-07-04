package com.bonton.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Bonton service end point interface operations available to 
 * Bonton API client . 
 * @author Tirath
 * @see BontonService
 */

@Path("/hotels")
public interface Service {
	
	@POST
	@Path("/search")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String search(@Context HttpServletRequest request) throws Exception;
	
	@POST
	@Path("/confirm")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String confirmBooking(@Context HttpServletRequest request) throws Exception;
	
	@POST
	@Path("/cancel")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String cancelBooking(@Context HttpServletRequest request) throws Exception;
	
	@POST
	@Path("/reprice")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String repricing(@Context HttpServletRequest request) throws Exception;
}
