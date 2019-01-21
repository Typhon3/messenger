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
 * A resource created to handle requests from a REST client
 * @author Simon Leu
 * @version 1.3
 */
@Path("/users")
public class UserResource {
	
	UserService userService = new UserService();

	/**
     * Method handling the HTTP GET request for all users.
     * @return All users returned as a JSON response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
    
    /**
     * Method handling the HTTP GET request for a single user.
     * @return One particular user returned as a JSON response.
     */
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") long userId) {
    	return userService.getUser(userId);
    }
    
    
    /**
     * Method handling a POST request for a single user.
     * @param user The user that is to be created
     * @return A long value with the created users id is returned
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public long addUser(User user) {
    	return userService.addUser(user);
    }
    
    
    /**
     * Method handling a DELETE request for a single user
     * @param id The id of the user that is to be deleted
     * @return A boolean is returned to indicate the deletions success
     */
    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteUserbyId(@PathParam("userId") int id) {
    	
		return userService.deleteById(id);
    	
    }

    
    /**
     * Method handling a PUT request for a single user
     * @param user The user with the updated information
     * @return A boolean is returned to indicate the updates success
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateUser(User user) {
    	return userService.updateUser(user);
    }
    
    
}