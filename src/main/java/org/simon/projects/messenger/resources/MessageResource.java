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
 * A resource created to handle requests from a REST client
 * @author Simon Leu
 * @version 1.4
 */
@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	/**
     * Method handling a GET request for all messages.
     * @return All messages returned as a JSON response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
    
    /**
     * Method handling a GET request for a single message.
     * @return One particular massage returned as a JSON response.
     */
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
    	return messageService.getMessage(messageId);
    }
    
    /**
     * Method handling a POST request for a single message.
     * @param msg The message that is to be created
     * @return A long value with the created messages id is returned
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public long addMessage(Message msg) {
    	return messageService.addMessage(msg);
    }
    
    /**
     * Method handling a DELETE request for a single message
     * @param id The id of the message that is to be deleted
     * @return A boolean is returned to indicate the deletions success
     */
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteMessagebyId(@PathParam("messageId") int id) {
		return messageService.deleteById(id);
    	
    }

    /**
     * Method handling a PUT request for a single message
     * @param msg The message with the updated information
     * @return A boolean is returned to indicate the updates success
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateMessage(Message msg) {
    	return messageService.updateMessage(msg);
    }
    
    
}
