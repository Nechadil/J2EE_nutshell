package com.nechadil.j2ee.rest.apis;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.nechadil.j2ee.model.JsonModel;

public class RestApplicationTest extends JerseyTest{
	@Override
    protected Application configure() {
        return new ResourceConfig(RestApplication.class);
    }
	
	@Test
	public void getJson_whenCorrectRequest_thenResponseJsonObject() {
		Response response = target("rest/getJson/hello").queryParam("id", "1").request().get();
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
		assertEquals(response.readEntity(String.class), new JsonModel("1", "hello").toString());
	}
	
	@Test
	public void postJson_whenCorrectRequest_thenResponseMessage() {
		JsonModel model = new JsonModel("1", "description");
		Entity<JsonModel> entity = Entity.json(model);
		Response response = target("rest/postJson").request().post(entity);
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(MediaType.TEXT_HTML, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
		assertEquals(response.readEntity(String.class), "<br>recieved model: " + new JsonModel("1", "description").toString() + "</br>");
	}
	
	@Test
	public void postJson_whenWrongContentTypeRequest_thenResponse415() {
		Entity<String> entity = Entity.text("abc");
		Response response = target("rest/postJson").request().post(entity);
		assertEquals(Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode(), response.getStatus());
	}
}
