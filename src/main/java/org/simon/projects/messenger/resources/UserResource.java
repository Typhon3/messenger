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

import org.simon.projects.messenger.beans.User;
import org.simon.projects.messenger.services.UserService;

/**
 * Root resource (exposed at "messages" path)
 */
@Path("/users")
public class UserResource {
	
	UserService userService = new UserService();

	/**
     * Method handling the HTTP GET request for all messages.
     * @return All messages returned as an XML response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
    	
		return userService.getAllUsers();
	}
    
    /**
     * Method handling the HTTP GET rewuest for a singular message.
     * @return One particular massage returned as an XML response.
     */
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") long userId) {
    	return userService.getUser(userId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addUser(User user) {
    	return userService.addUser(user);
    }
    
    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteUserbyId(@PathParam("userId") int id) {
    	
		return userService.deleteById(id);
    	
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateUser(User user) {
    	return userService.updateUser(user);
    }
    
    
}