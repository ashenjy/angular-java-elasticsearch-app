package org.ashen.domain.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Path("/userlist")
public class userController {
	
	//userService userService=new userService();
	
	TransportClient client;

    public userController() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Map<String , Object> getAllUsers() {
        GetResponse getResponse = client.prepareGet("employee", "id", "1")
  
        		.get();
                    
                
        		
        System.out.println(getResponse.getSource());


        return getResponse.getSource();
    } 
	


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getAUser(@PathParam("id") final String id) {
        GetResponse getResponse = client.prepareGet("employee", "id", id).get();
        System.out.println(getResponse.getSource());


        return getResponse.getSource();
	}
   
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public String insert(String sname , String sage) throws IOException {

    	
    	
    	 IndexResponse response = client.prepareIndex("employee", "id", "1")
                 .setSource(jsonBuilder()
                         .startObject()
                         .field("name", sname)
                         .field("age", sage)

                         .endObject()
                 )
                 .get();
         return response.getResult().toString();

	}

    /*@PUT
    @Produces(MediaType.APPLICATION_JSON)
	public user updateuser(user user)
	{
		return userService.updateuser(user);
		
	} */
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("id") final String id) {
	
		DeleteResponse deleteResponse = client.prepareDelete("employee", "id", id).get();

        System.out.println(deleteResponse.getResult().toString());
        return deleteResponse.getResult().toString();
	}
	
	
	
	
}
