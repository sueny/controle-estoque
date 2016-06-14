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
import projeto.engenharia.software.controle.estoque.base.entity.Product;
import projeto.engenharia.software.controle.estoque.base.entity.ProductMaterial;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IProductAS;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(Product product) {
        try {
            for (ProductMaterial productMaterial : product.getListMaterial()) {
                productMaterial.setProduct(product);
            }

            as.save(product);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<Product> list = new ArrayList<>();
        try {
            list = as.list(Product.class);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarpornomeskucode/")
    public Response listarPorNomeSkuoCde(Product product) {
        List<Product> list = new ArrayList<>();
        try {
            if (product.getName() != null && !product.getName().equals("")) {
                list = as.list("Product.buscarPorName", product.getName().concat("%"));

            } else if (product.getSkuCode() != null && !product.getSkuCode().equals("")) {
                list = as.list("Product.buscarPorSkuCode", product.getSkuCode().concat("%"));
            }

            return Response.ok(
                    new ModelData<>(true, list)
            ).build();

        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("remover/")
    public Response remover(Product product) {
        try {
            as.remove(product);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

}
