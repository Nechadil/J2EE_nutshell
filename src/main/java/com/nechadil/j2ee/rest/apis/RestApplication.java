package com.nechadil.j2ee.rest.apis;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.nechadil.j2ee.model.JsonModel;

//Jersey can't scan this class if no @Path decorates the class (even though the method may be decorated!)
@Path("rest")
public class RestApplication {
	
	/**
	 * GET request with {@code @PathParam} and {@code @QueryParam} example
	 */
	@GET
	@Path("getJson/{description}")
	@Produces("application/json")
	public JsonModel getJson(@QueryParam("id") String id, @PathParam("description") String description) {
		return new JsonModel(id, description);
	}
	
	/**
	 * POST request which consumes json object
	 * @param jsonModel
	 * @return
	 */
	@POST
	@Path("postJson")
	@Consumes("application/json")
	@Produces("text/html")
	public String postJson(JsonModel jsonModel) {
		return "<br>recieved model: " + jsonModel.toString() + "</br>";
	}

}
