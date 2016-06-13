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
import projeto.engenharia.software.controle.estoque.base.entity.ModelData;
import projeto.engenharia.software.controle.estoque.base.entity.ProductMaterial;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IProductMaterialAS;

/**
 * REST Web Service
 * TODO excluir esta classe
 *
 * @author Vitor
 */
//@Path("productmaterial")
//@RequestScoped
public class ProductMaterialResource {

    /*
    @Inject
    IProductMaterialAS as;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(ProductMaterial productMaterial) {
        try {
            as.save(productMaterial);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductMaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<ProductMaterial> list = new ArrayList<>();
        try {
            list = as.list(ProductMaterial.class);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductMaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(ProductMaterial productMaterial) {
        try {
            as.remove(productMaterial);
            return Response.ok(new ModelData<Boolean>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductMaterialResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }
*/
}
