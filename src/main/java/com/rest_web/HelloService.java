package com.rest_web;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloService {
    
    @Path("helloworld")
    @GET
    @Produces("text/plain")
    public String helloworld() {
        return "Hello Rest";
    }
    
    @Path("greet")
    @GET
    @Produces("text/plain")
    public String greet(@QueryParam("name") String name) {
        return "Hello " + name;
    }
    
    @Path("product/{id}")
    @GET
    @Produces("text/plain")
    public String product(@PathParam("id") String id) {
        return "Product id = " + id;
    }
    
    
}
