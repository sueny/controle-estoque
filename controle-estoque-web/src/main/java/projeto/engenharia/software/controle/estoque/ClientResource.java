package projeto.engenharia.software.controle.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IClientAS;
import projeto.engenharia.software.controle.estoque.base.entity.Client;
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;

/**
 * REST Web Service
 *
 * @author Vitor
 */
@Path("customer")
@RequestScoped
public class ClientResource {

    @Inject
    IClientAS as;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(Client client) {
        try {
            as.save(client);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ClientResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<Client> list = new ArrayList<>();
        try {
            list = as.list(Client.class);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ClientResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(Client client) {
        try {
            as.remove(client);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ClientResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }
}
