package org.simon.projects.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.simon.projects.messenger.beans.Message;
import org.simon.projects.messenger.services.MessageService;

/**
 * Root resource (exposed at "messages" path)
 */
@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	/**
     * Method handling the HTTP GET request for all messages.
     * @return All messages returned as an XML response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
    
    /**
     * Method handling the HTTP GET rewuest for a singular message.
     * @return One particular massage returned as an XML response.
     */
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
    	return messageService.getMessage(messageId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message msg) {
    	messageService.addMessage(msg);
    	return msg;
    }
    
    @DELETE
    @Path("/messageId")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMessagebyId(@PathParam("messageId") int id) {
		return "DELETE works";
    	
    }

    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updateMessage() {
    	return "PUT works";
    }
    
    
}
