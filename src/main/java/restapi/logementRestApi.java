package restapi;

import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.PixelGrabber;


  @Path("/logement")
  public class logementRestApi {

      LogementBusiness logementBusiness = new LogementBusiness();


      @GET
      @Produces(MediaType.APPLICATION_JSON)
      @Path("/list")

      public Response getAll() {
          return Response.ok().entity(logementBusiness.getLogements()).build();
      }


      @POST
      @Produces(MediaType.TEXT_PLAIN)
      @Consumes(MediaType.APPLICATION_JSON)
      @Path("/add")

      public Response addLogement(Logement logement) {
          logementBusiness.addLogement(logement);

          return Response.status(201).entity("Logement a été ajouté avec success").build();
      }


      @DELETE
      @Produces(MediaType.TEXT_PLAIN)
      @Consumes(MediaType.APPLICATION_JSON)
      @Path("/delete")
      public Response deleteLogement(Logement logement) {
          LogementBusiness.deleteLogement(logement.getReference());
          return Response.status(Response.Status.OK)
                  .entity("Logement a été supprimé avec succès")
                  .build();
      }


      @PUT
      @Produces(MediaType.TEXT_PLAIN)
      @Consumes(MediaType.APPLICATION_JSON)
      @Path("/update/{reference}")
      public Response updateLogement(@PathParam("reference") int reference, Logement logement) {
          boolean updated = LogementBusiness.updateLogement(reference, logement);

          if (updated) {
              return Response.status(Response.Status.OK)
                      .entity("Logement mis à jour avec succès")
                      .build();
          } else {
              return Response.status(Response.Status.NOT_FOUND)
                      .entity("Logement non trouvé")
                      .build();
          }
      }


  }
