package ar.com.educacionit.ws.rest.configuracion;

import org.glassfish.jersey.server.ResourceConfig;

import ar.com.educacionit.ws.rest.filters.AuthenticationFilter;

public class AppWSRestApplication extends ResourceConfig {

	 public AppWSRestApplication() 
	    {
	       // packages("com.howtodoinjava.jersey");
	       // register(LoggingFilter.class);
	       // register(GsonMessageBodyHandler.class);
	 
	        //Register Auth Filter here
	        register(AuthenticationFilter.class);
	        register(CORSFilter.class);
	    }
}
