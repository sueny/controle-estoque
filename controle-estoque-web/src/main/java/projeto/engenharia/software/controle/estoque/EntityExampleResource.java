/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.EntityExample;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IEstoqueAS;

/**
 * REST Web Service
 *
 * @author house
 */
@Path("entityexample")
@RequestScoped
public class EntityExampleResource {

    @Inject
    IEstoqueAS as;

    /**
     * Creates a new instance of EstoqueResource
     */
    public EntityExampleResource() {
    }

    /**
     * Retrieves representation of an instance of projeto.engenharia.software.controle.estoque.EstoqueResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EstoqueResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
  @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("findbyid/")
    public Response findEntityExampleById(@FormParam("id") Integer id) {
        EntityExample entityExample = null;
        try {
            entityExample = as.findEntityExampleById(id);
        } catch (Exception ex) {
            Logger.getLogger(EntityExampleResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(entityExample).build();
    }
    
}
