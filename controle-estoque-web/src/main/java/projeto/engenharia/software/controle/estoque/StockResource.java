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
import projeto.engenharia.software.controle.estoque.base.entity.Stock;
import projeto.engenharia.software.controle.estoque.base.entity.as.iface.IStockAS;

/**
 * REST Web Service
 *
 * @author sueny
 */
@Path("estoque")
@RequestScoped
public class StockResource {

    @Inject
    IStockAS as;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastrar/")
    public Response cadastrar(Stock stock) {
        try {
            as.save(stock);
            return Response.ok(new ModelData<>(true)).build();
        } catch (Exception ex) {
            Logger.getLogger(StockResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/")
    public Response listar() {
        List<Stock> list = new ArrayList<>();
        try {
            list = as.list(Stock.class);
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(StockResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }

    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarproduto/")
    public Response listarProduto(Product product) {
        List<Stock> list = new ArrayList<>();
        try {
            if (product.getName() != null && !product.getName().equals("")) {
                list = as.list("Stock.buscarPorProductName", product.getName().concat("%"));

            } else if (product.getSkuCode() != null && !product.getSkuCode().equals("")) {
                list = as.list("Stock.buscarPorProductSkuCode", product.getSkuCode().concat("%"));
            }
            
            return Response.ok(
                    new ModelData<>(true, list)
            ).build();
        } catch (Exception ex) {
            Logger.getLogger(StockResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(
                    new ModelData<>(false, ex.getCause().getMessage(), null)
            ).build();
        }

    }

}
