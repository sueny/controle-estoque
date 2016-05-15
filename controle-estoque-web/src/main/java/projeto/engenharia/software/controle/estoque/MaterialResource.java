/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.Material;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IMaterialAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("material")
@RequestScoped
public class MaterialResource {

    @Inject
    IMaterialAS as;

    /**
     * Creates a new instance of EstoqueResource
     */
    public MaterialResource() {
    }

    /**
     * Retrieves representation of an instance of
     * projeto.engenharia.software.controle.estoque.EstoqueResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        return "bla";
//    }
    /**
     * PUT method for updating or creating an instance of EstoqueResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(Material material) {
        try {
            as.save(material);
            return Response.ok(true).build();
        } catch (Exception ex) {
            Logger.getLogger(MaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(false).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<Material> list = new ArrayList<>();
        try {
            list = as.list("Material.listarTodos");
        } catch (Exception ex) {
            Logger.getLogger(MaterialResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(list).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(Material material) {
        try {
            as.remove(material);
            return Response.ok(true).build();
        } catch (Exception ex) {
            Logger.getLogger(MaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(false).build();
        }
    }
}
