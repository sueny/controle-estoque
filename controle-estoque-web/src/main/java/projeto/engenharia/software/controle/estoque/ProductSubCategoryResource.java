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
import projeto.engenharia.software.controle.estoque.base.entity.ProductSubCategory;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IProductSubCategoryAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("productsubcategory")
@RequestScoped
public class ProductSubCategoryResource {

    @Inject
    IProductSubCategoryAS as;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(ProductSubCategory productSubCategory) {
        try {
            as.save(productSubCategory);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductSubCategoryResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<ProductSubCategory> list = new ArrayList<>();
        try {
            list = as.list(ProductSubCategory.class);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductSubCategoryResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(ProductSubCategory productSubCategory) {
        try {
            as.remove(productSubCategory);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductSubCategoryResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }
}
