
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
import projeto.engenharia.software.controle.estoque.base.entity.Material;
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(Material material) {
        try {
            as.save(material);
            return Response.ok(new ModelData<Boolean>(true, null)).build();
        } catch (Exception ex) {
            Logger.getLogger(MaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<Boolean>(false, ex.getCause().getMessage(), null)
            ).build();
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
        return Response.ok(
                new ModelData<List<Material>>(true, list)
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(Material material) {
        try {
            as.remove(material);
            return Response.ok(new ModelData<Boolean>(true, null)).build();
        } catch (Exception ex) {
            Logger.getLogger(MaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<Boolean>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }
}
