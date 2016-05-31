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
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.*;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.*;


/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("product")
@RequestScoped
public class ProductResource {

    @Inject
    IProductAS as;

    /**
     * Creates a new instance of EstoqueResource
     */
    
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of
     * projeto.engenharia.software.controle.estoque.EstoqueResource
     *
     * @return an instance of java.lang.String
     */

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
    public Response cadastrar(Product product) {
        try {
            as.save(product);
            return Response.ok(true).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(false).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<Product> list = new ArrayList<>();
        try {
           list = as.list(Product.class);
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(list)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(Product product) {
        try {
            as.remove(product);
            return Response.ok(true).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(false).build();
        }
    }
}
