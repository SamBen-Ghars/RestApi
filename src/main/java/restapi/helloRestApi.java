package restapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/hello")
public class helloRestApi {


   @GET
   @Produces(MediaType.TEXT_PLAIN)
   @Path("/hi")
    public Response sayHi(){

        return  Response.status(200).entity("hello wored").build();

    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")//pathparame
    public Response sayHiTo(@PathParam(value = "name")String name,

                            @QueryParam(value = "Lname") String Lname){

        return  Response.status(200).entity("hello "+ name +"   " +Lname).build();

    }
}
