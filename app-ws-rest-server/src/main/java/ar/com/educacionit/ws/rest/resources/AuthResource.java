package ar.com.educacionit.ws.rest.resources;

import java.util.Base64;

import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.services.UserService;
import ar.com.educacionit.services.impl.UserServiceImpl;

@Path("auth")
public class AuthResource {

	private UserService userService = new UserServiceImpl();
	
	//POST http://localhost:8080/contexto/api/auth?username=pepe&passwoprd=pepe
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response login(
			@QueryParam("username") String username,
			@QueryParam("password") String password) {
		
		//basic auth
		ResponseBuilder response = Response.ok();
		
		try {
			User user = userService.getUserByUserName(username);
			
			if(user != null && password.equals(user.getPassword()))  {
				String basic = user.getUsername()+":"+user.getPassword();
			    String basicEncoded = new String(Base64.getEncoder().encode(basic.getBytes()));
				response.header("Authorization", basicEncoded);
			}else {
				response = Response.status(Status.UNAUTHORIZED);
			}
		}catch (Exception e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		
		return response.build();
	}
}
